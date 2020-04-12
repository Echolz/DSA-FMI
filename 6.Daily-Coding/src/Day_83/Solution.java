package Day_83;


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode currentNode = head;

    if (currentNode == null) {
      return null;
    }

    int i = 1;
    while (currentNode.next != null) {
      currentNode = currentNode.next;
      i++;
    }

    i = (i / 2) + 1;


    int j = 0;
    currentNode = head;
    while (j != i - 1) {
      currentNode = currentNode.next;
      j++;
    }

    return currentNode;
  }
}
