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
    public ListNode getReverseList(ListNode head){
        ListNode next = head;
        ListNode current = head;
        ListNode prev = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) {
        ListNode node = getReverseList(head);
        int result = 0;
        int counter = 0;
        while(node!=null){
            result += node.val * Math.pow(2,counter);
            node = node.next;
            counter++;
        }
        return result;
    }
}