package E_6_1;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    public BinarySearchTree() {
        head = null;
        size = 0;
    }

    public boolean insert(T value) {
        if (head == null) {
            head = new Node<>(value);
            size++;
            return true;
        }

        boolean inserted = dfsInsert(head, new Node<>(value));

        if (inserted) {
            size++;
        }

        return inserted;
    }

    public boolean contains(T value) {
        if (head == null) {
            return false;
        }

        return dfsContains(head, value);
    }

    public T getMaxValue() {
        if (head == null) {
            return null;
        }

        Node<T> node = dfsMaxValue(head);

        return node.getValue();
    }

    public T getMinValue() {
        if (head == null) {
            return null;
        }

        Node<T> node = dfsGetMinValue(head);

        return node.getValue();
    }

    public boolean remove(T value) {
        if (size == 1 && head.getValue().compareTo(value) == 0) {
            size = 0;
            head = null;
            return true;
        }

        Wrapper<T> wrapper = getWrapper(null, head, false, value);

        if (wrapper == null) {
            return false;
        }

        handleWrapper(wrapper);

        return true;
    }

    private void handleWrapper(Wrapper<T> wrapper) {
        // TODO: 6.12.2018 g. with two children and node is head

        Node<T> nodeToReplace = wrapper.getChild();
        Node<T> parent = wrapper.getParent();
        boolean fromRight = wrapper.isFromRight();
        boolean hasLeftChild = nodeToReplace.getLeft() != null;
        boolean hasRightChild = nodeToReplace.getRight() != null;

        if (!hasLeftChild && !hasRightChild) {
            if (fromRight) {
                parent.setRight(null);
            } else {
                parent.setLeft(null);
            }
        }

        if (hasLeftChild && !hasRightChild) {
            if (fromRight) {
                parent.setRight(nodeToReplace.getLeft());
            } else {
                parent.setLeft(nodeToReplace.getLeft());
            }
        }

        if (!hasLeftChild && hasRightChild) {
            if (fromRight) {
                parent.setRight(nodeToReplace.getRight());
            } else {
                parent.setLeft(nodeToReplace.getRight());
            }
        }
    }

    private Wrapper<T> getWrapper(Node<T> parent, Node<T> currentNode, boolean fromRight, T value) {
        if (currentNode.getValue().compareTo(value) == 0) {
            return new Wrapper<>(parent, currentNode, fromRight);
        }

        if (currentNode.getLeft() != null && value.compareTo(currentNode.getValue()) < 0) {
            return getWrapper(currentNode, currentNode.getLeft(), false, value);
        }

        if (currentNode.getRight() != null && value.compareTo(currentNode.getValue()) > 0) {
            return getWrapper(currentNode, currentNode.getRight(), true, value);
        }

        return null;
    }

    private Node<T> dfsMaxValue(Node<T> curNode) {
        if (curNode.getRight() != null) {
            return dfsMaxValue(curNode.getRight());
        }

        return curNode;
    }

    private Node<T> dfsGetMinValue(Node<T> curNode) {
        if (curNode.getLeft() != null) {
            return dfsGetMinValue(curNode.getLeft());
        }

        return curNode;
    }

    public List<T> getSorted() {
        List<T> sortedList = new ArrayList<>();
        dfsInOrder(head, sortedList);

        return sortedList;
    }

    public int size() {
        return size;
    }

    private boolean dfsContains(Node<T> curNode, T value) {
        if (curNode.getValue().compareTo(value) == 0) {
            return true;
        }

        if (curNode.getLeft() != null && value.compareTo(curNode.getValue()) < 0) {
            return dfsContains(curNode.getLeft(), value);
        }

        if (curNode.getRight() != null && value.compareTo(curNode.getValue()) >= 0) {
            return dfsContains(curNode.getRight(), value);
        }

        return false;
    }

    private void dfsInOrder(Node<T> curNode, List<T> sortedList) {
        if (curNode.getLeft() != null) {
            dfsInOrder(curNode.getLeft(), sortedList);
        }

        sortedList.add(curNode.getValue());

        if (curNode.getRight() != null) {
            dfsInOrder(curNode.getRight(), sortedList);
        }
    }

    private boolean dfsInsert(Node<T> curNode, Node<T> newNode) {
        if (curNode.getLeft() == null && newNode.getValue().compareTo(curNode.getValue()) < 0) {
            curNode.setLeft(newNode);
            return true;
        }

        if (curNode.getRight() == null && newNode.getValue().compareTo(curNode.getValue()) > 0) {
            curNode.setRight(newNode);
            return true;
        }

        if (curNode.getValue().compareTo(newNode.getValue()) == 0) {
            return false;
        }

        if (newNode.getValue().compareTo(curNode.getValue()) < 0) {
            return dfsInsert(curNode.getLeft(), newNode);
        } else {
            return dfsInsert(curNode.getRight(), newNode);
        }
    }
}

class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    Node(T value) {
        this.value = value;
    }

    Node<T> getLeft() {
        return left;
    }

    void setLeft(Node<T> left) {
        this.left = left;
    }

    Node<T> getRight() {
        return right;
    }

    void setRight(Node<T> right) {
        this.right = right;
    }

    T getValue() {
        return value;
    }
}

class Wrapper<T extends Comparable<T>> {
    private Node<T> parent;
    private Node<T> child;
    private boolean fromRight;

    Wrapper(Node<T> parent, Node<T> child, boolean fromRight) {
        this.parent = parent;
        this.child = child;
        this.fromRight = fromRight;
    }

    public Node<T> getParent() {
        return parent;
    }

    public Node<T> getChild() {
        return child;
    }

    public boolean isFromRight() {
        return fromRight;
    }
}
