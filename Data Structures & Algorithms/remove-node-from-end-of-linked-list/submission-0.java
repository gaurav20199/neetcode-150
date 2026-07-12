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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        int len = length(head);
        int count=1;
        ListNode dummyNode = new ListNode(-1);
        ListNode storeDummy = dummyNode;
        dummyNode.next = head;
        while(count<=len-n) {
            dummyNode = dummyNode.next;
            count++;
        }
        ListNode nextToNextNode = (dummyNode==null || dummyNode.next==null)?null:dummyNode.next.next;
        dummyNode.next = nextToNextNode;
        return storeDummy.next;
    }

    public int length(ListNode head) {
        ListNode temp = head;
        int len=0;
        while(temp!=null) {
            temp = temp.next;
            len++;
        }
        return len;
    }
}
