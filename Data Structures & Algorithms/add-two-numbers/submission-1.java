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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode storeDummy = dummy;
        int carry = 0;
        while(l1!=null && l2!=null) {
             int newNodeVal = (l1.val+l2.val+carry)%10;
             carry = (l1.val+l2.val+carry)/10;
             dummy.next = new ListNode(newNodeVal);
             dummy = dummy.next;
             l1 = l1.next;
             l2 = l2.next;
        }
        while(l1!=null) {
            int newNodeVal = (l1.val+carry)%10;
            carry = (l1.val+carry)/10;
            dummy.next = new ListNode(newNodeVal);
            dummy = dummy.next;
            l1 = l1.next;

        }

        while(l2!=null) {
            int newNodeVal = (l2.val+carry)%10;
            carry = (l2.val+carry)/10;
            dummy.next = new ListNode(newNodeVal);
            dummy = dummy.next;
            l2 = l2.next;
        }
        if(carry>0) {
            dummy.next= new ListNode(carry);
            dummy = dummy.next;
        }

        dummy.next = null;
        return storeDummy.next;    
    }
}
