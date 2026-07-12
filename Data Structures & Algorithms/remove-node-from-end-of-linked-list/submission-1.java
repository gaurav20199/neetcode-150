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

        ListNode fast = head;
        int count = 0;
        while(count<n) {
            fast = fast.next;
            count++;
        }    
        
        ListNode dummyNode = new ListNode(-1);
        ListNode storeDummy = dummyNode;
        dummyNode.next = head;
        while(fast!=null) {
            fast = fast.next;
            dummyNode = dummyNode.next;
        }
        //System.out.println(dummyNode.val);
        dummyNode.next = dummyNode==null || dummyNode.next==null?null:dummyNode.next.next;
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
