# 876. Middle of the Linked List (Java)

## Problem
Find the middle node of a singly linked list. If the list has an even number of nodes, return the second of the two middle nodes.

## Approach
The initial solution uses the classic fast and slow pointer technique. Both `slow` and `fast` pointers start at the list's head. The `slow` pointer moves one step at a time. The `fast` pointer moves two steps at a time. When the `fast` pointer reaches the end of the list, the `slow` pointer will be at a middle node.

## Complexity
- **Time**: O(N). The fast pointer traverses the list, making about N/2 iterations.
- **Space**: O(1). Only two pointers are used, requiring constant extra space.

## Review
The initial solution correctly finds the middle node for odd-length lists. However, it does not fully meet the problem's specific requirement for even-length lists. For an even-length list, it returns the *first* of the two middle nodes, while the problem asks for the *second*.

## Improvements
To correctly return the second middle node for even-length lists, the fast pointer's initialization needs adjustment. Start `slow` at `head` and `fast` at `head.next`. This offset ensures `slow` lands on the second middle node for even lists, while still correctly finding the unique middle for odd lists. This optimized approach maintains O(N) time and O(1) space complexity.

## Takeaways
- Fast and slow pointers are a powerful technique for linked list problems.
- Careful initialization and loop conditions are crucial for specific requirements.
- Always test edge cases (e.g., list length 1, 2, odd, even).
- Pay close attention to subtle details in problem statements.