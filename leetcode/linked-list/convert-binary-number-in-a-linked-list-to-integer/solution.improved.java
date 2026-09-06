class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode current = head;
        while (current != null) {
            // Multiply current result by 2 (left shift) and add the current bit
            result = (result << 1) | current.val; // Equivalent to result = result * 2 + current.val;
            current = current.next;
        }
        return result;
    }
}