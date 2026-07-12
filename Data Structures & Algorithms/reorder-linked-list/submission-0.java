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
        ListNode prevHead = reversedHead;
        while(temp!=slow) {
            if(temp!=head) {
                prevHead.next = temp;
            }
            ListNode nextPtr = temp.next;
            temp.next = reversedHead;
            prevHead = reversedHead;
            reversedHead = reversedHead.next;
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
