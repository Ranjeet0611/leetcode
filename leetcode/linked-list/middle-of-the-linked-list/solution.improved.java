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
    public ListNode middleNode(ListNode head) {
        // Constraints state N is in range [1, 100], so head will never be null.
        ListNode slow = head;
        ListNode fast = head.next; // Initialize fast one step ahead of slow

        // The loop condition remains the same: fast and fast.next must not be null.
        // This ensures fast can always move two steps.
        while(fast != null && fast.next != null){
            fast = fast.next.next; // Fast moves two steps
            slow = slow.next;     // Slow moves one step
        }
        // When the loop terminates:
        // If list length is odd (e.g., [1,2,3,4,5]):
        //   Initial: slow=1, fast=2
        //   1st iter: slow=2, fast=4
        //   2nd iter: slow=3, fast=null (from 4.next.next)
        //   Loop ends. slow is 3 (the middle node).
        // If list length is even (e.g., [1,2,3,4,5,6]):
        //   Initial: slow=1, fast=2
        //   1st iter: slow=2, fast=4
        //   2nd iter: slow=3, fast=6
        //   3rd iter: slow=4, fast=null (from 6.next.next)
        //   Loop ends. slow is 4 (the second middle node).
        return slow;
    }
}