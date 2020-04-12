package Day_85;

public class Solution {
  public static void main(String[] args) {
    String[] commands = {"MinStack", "push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop", "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin"};
    Integer[] answers = {null, 2147483646, 2147483646, 2147483647, null, null, null, null, null, null, 2147483647,
        null, null, -2147483648, null, null, null, null};

    MinStack stack = new MinStack();

    for (int i = 0; i < commands.length; i++) {
      String command = commands[i];
      Integer answer = answers[i];

      if (command.equals("push")) {
        stack.push(answer);
      }

      if (command.equals("top")) {
        stack.top();
      }

      if (command.equals("getMin")) {
        stack.getMin();
      }

      if (command.equals("pop")) {
        stack.pop();
      }
    }
  }
}

class MinStack {
  Integer minValue;
  Node tail;

  public MinStack() {

  }

  public void push(int x) {
    if (tail == null) {
      tail = new Node(x);
      minValue = x;
      return;
    }

    Node newNode = new Node(x);

    //if the new node has lower value
    if (newNode.value <= minValue) {
      newNode.prevMinNode = minValue;
      minValue = newNode.value;
    }

    tail.nextNode = newNode;
    newNode.prevNode = tail;
    tail = newNode;
  }

  public void pop() {
    if (tail == null) {
      return;
    }

    if (tail.prevMinNode != null) {
      minValue = tail.prevMinNode;
    }

    tail = tail.prevNode;

    if (tail == null) {
      return;
    }

    tail.nextNode = null;
  }

  public int top() {
    if (tail == null) {
      return Integer.MAX_VALUE;
    }

    return tail.value;
  }

  public int getMin() {
    return minValue;
  }
}

class Node {
  Node prevNode;
  Node nextNode;
  Integer prevMinNode;
  int value;


  public Node(int value) {
    this.value = value;
  }
}
