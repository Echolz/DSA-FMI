package Day_51;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        ListNode head = node;
        ListNode tail = head.next;

        while (tail != null) {
            head.val = tail.val;
            head = tail;
            tail = tail.next;
        }

        while (node.next.next != null) {
            node = node.next;
        }

        node.next = null;
    }
}
