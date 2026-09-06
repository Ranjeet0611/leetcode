## Problem
Convert a binary number, represented as a singly-linked list, to its decimal integer value. The head of the list is the most significant bit (MSB).

## Approach
The initial solution first reverses the entire linked list. Then, it iterates through the reversed list. It calculates the decimal value by summing `node.val * 2^counter`, where `counter` starts from 0 for the least significant bit.

## Complexity
*   **Time:** O(N). Reversing the list takes O(N). Traversing the reversed list takes another O(N).
*   **Space:** O(1). The reversal is done in-place using a few pointers.

## Review
The current solution has several inefficiencies.
1.  **Unnecessary Reversal:** Reversing the linked list is not required. The decimal value can be computed in a single forward pass.
2.  **Input Modification:** The reversal modifies the original input linked list. This is often undesirable.
3.  **`Math.pow` Usage:** Using `Math.pow` is less efficient for calculating integer powers of 2. Bitwise left shift (`1 << counter`) or simple multiplication (`result * 2`) is preferred.

## Improvements
The accepted solution is not optimal.
A better approach calculates the decimal value in a single forward pass. Initialize a `result` variable to 0. Iterate through the linked list from head to tail. For each node, update `result` using the formula `result = (result * 2) + node.val`. This efficiently converts the binary sequence from MSB to LSB. This method avoids list reversal and uses more efficient arithmetic.

## Takeaways
*   **Single Pass vs. Multiple Passes:** Always consider if a problem can be solved in a single pass, especially with linked lists.
*   **Binary to Decimal Conversion:** The pattern `result = result * 2 + bit` (or `result = (result << 1) | bit`) is a fundamental and efficient way to convert a binary sequence.
*   **Avoid Unnecessary Operations:** Skip steps like list reversal if they are not strictly required.
*   **Efficient Arithmetic:** Prefer bit shifts or simple multiplication over `Math.pow` for powers of 2.
*   **Immutability of Inputs:** Good practice often dictates not modifying input data structures unless explicitly required.

## Where it applies
This problem primarily uses **Singly-Linked Lists**. This is a fundamental data structure for dynamic memory allocation and implementing various abstract data types.

**Patterns:**
*   **Traversal:** Iterating through a linked list is a common operation.
*   **Binary Representation & Bit Manipulation:** Understanding how binary numbers are represented and converted to decimal is crucial. The `result = result * 2 + bit` pattern is a direct application. Bitwise operations (`<<`, `|`) are often used for efficiency with binary data.

**Related LeetCode Problems:**
*   21. Merge Two Sorted Lists (Linked List Traversal)
*   206. Reverse Linked List (Linked List Traversal)
*   191. Number of 1 Bits (Bit Manipulation)
*   338. Counting Bits (Bit Manipulation)