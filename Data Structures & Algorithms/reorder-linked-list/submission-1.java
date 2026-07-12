/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversedHead = reverseList(slow);
        ListNode temp = head;
        while(temp!=slow) {
            ListNode nextPtr = temp.next;
            ListNode reversedNextPtr = reversedHead.next;
            temp.next = reversedHead;
            reversedHead.next = nextPtr;
            reversedHead = reversedNextPtr;
            temp = nextPtr;
        }
        slow.next = null;
    }

    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        while(node!=null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
