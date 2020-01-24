package Day_66;

import java.io.FileNotFoundException;
import java.util.*;

class Node {
  public int data;
  public int level;
  public Node left;
  public Node right;

  public Node(int value) {
    data = value;
    left = null;
    right = null;
  }
}

public class BST {
  private Node root;

  public void insert(int value) {
    root = insertHelper(root, value);
  }

  private Node insertHelper(Node node, int value) {
    if (node == null) {
      node = new Node(value);
    } else if (node.data > value) {
      node.left = insertHelper(node.left, value);
    } else if (node.data < value) {
      node.right = insertHelper(node.right, value);
    }
    return node;
  }

  Set<Integer> levels = new HashSet<Integer>();
  List<Integer> answers = new ArrayList<Integer>();

  public void printLeftProfile() {
    Queue<Node> queue = new LinkedList<Node>();

    Node currentNode = root;
    root.level = 0;

    queue.add(currentNode);

    while (!queue.isEmpty()) {
      currentNode = queue.poll();

      if (!levels.contains(currentNode.level)) {
        levels.add(currentNode.level);
        answers.add(currentNode.data);
      }

      if (currentNode.left != null) {
        currentNode.left.level = currentNode.level + 1;
        queue.add(currentNode.left);
      }

      if (currentNode.right != null) {
        currentNode.right.level = currentNode.level + 1;
        queue.add(currentNode.right);
      }
    }

    for (Integer answer : answers) {
      System.out.print(answer + " ");
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    BST tree = new BST();
    for (int i = 0; i < n; i++) {
      tree.insert(in.nextInt());
    }
    tree.printLeftProfile();
  }
}
