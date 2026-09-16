## Problem

Find the minimum absolute difference between any two node values in a Binary Search Tree (BST).

## Approach

The first solution uses a key property of BSTs: an in-order traversal visits nodes in ascending order.

1.  Perform an in-order traversal of the BST.
2.  Collect all node values into an `ArrayList`.
3.  Once the list is populated, iterate through it.
4.  Calculate the absolute difference between each adjacent pair of elements.
5.  Keep track of the smallest difference found.
6.  Return this minimum difference.

## Complexity

*   **Time:** O(N), where N is the number of nodes in the BST. The in-order traversal visits each node once. Iterating the list also takes O(N) time.
*   **Space:** O(N), where N is the number of nodes. An `ArrayList` stores all N node values. The recursive call stack can also use up to O(N) space in the worst case (a skewed tree).

## Review

The accepted solution is clear and correct. It effectively uses the sorted nature of an in-order BST traversal. Initializing the minimum difference with `Integer.MAX_VALUE` is appropriate. The logic correctly identifies that the minimum difference must be between adjacent elements in a sorted list.

## Improvements

The current solution uses O(N) auxiliary space for the `ArrayList`. This can be optimized to O(1) auxiliary space (excluding the recursion stack). We can find the minimum difference during the in-order traversal itself. We only need to keep track of the value of the previously visited node.

## Optimized Approach

This optimized approach also uses an in-order traversal.

1.  Initialize `minDiff` to `Integer.MAX_VALUE`.
2.  Initialize `prevVal` to `null` (or a sentinel value). This will store the value of the node visited just before the current one in in-order sequence.
3.  Perform a recursive in-order traversal:
    *   First, traverse the left subtree.
    *   Then, process the current node:
        *   If `prevVal` is not `null`, calculate `current.val - prevVal`. Update `minDiff` if this difference is smaller.
        *   Update `prevVal` to `current.val`.
    *   Finally, traverse the right subtree.
4.  After the traversal, `minDiff` will hold the minimum absolute difference.

## Takeaways

1.  **BST In-order Traversal Property:** An in-order traversal of a BST visits nodes in ascending order. This is crucial for many BST problems.
2.  **Minimum Difference in Sorted Data:** To find the minimum difference between any two elements in a sorted sequence, you only need to check adjacent elements.
3.  **Space Optimization in Tree Traversal:** For problems needing comparisons between 'previous' and 'current' nodes, you can often optimize space. Maintain a few state variables (like `prevVal` and `minDiff`) instead of storing all results in a list. This reduces auxiliary space from O(N) to O(1).

## Where it applies

This problem highlights fundamental concepts of Binary Search Trees and tree traversals.

**Data Structures & Patterns:**

*   **Binary Search Trees (BSTs):** Useful for maintaining sorted data. Efficient for search, insertion, and deletion.
*   **In-order Traversal:** A standard tree traversal that processes nodes in sorted order for BSTs.
*   **Recursion:** Trees are naturally recursive. Recursive solutions are often elegant for tree operations.
*   **State Management during Traversal:** Keeping track of variables like `prevVal` or `minDiff` across recursive calls to optimize space.

**When to reach for them:**

*   When you need to process BST nodes in sorted order.
*   When comparing a node's value with its in-order predecessor or successor.
*   To optimize space in tree traversal problems by avoiding auxiliary data structures.

**Other LeetCode Problems it Unlocks:**

*   94. Binary Tree Inorder Traversal
*   98. Validate Binary Search Tree
*   230. Kth Smallest Element in a BST