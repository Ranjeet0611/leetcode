## Problem

This problem asks us to check if a given binary tree is a valid Binary Search Tree (BST). A valid BST follows specific rules:
- The left subtree of a node contains only values less than the node's value.
- The right subtree of a node contains only values greater than the node's value.
- Both the left and right subtrees must also be valid BSTs.

## Approach

The solution uses a recursive Depth-First Search (DFS) with range validation. We define a helper function that takes the current node and its allowed minimum and maximum values.

1.  **Base Case**: If the node is null, it's a valid subtree, return true.
2.  **Validation**: Check if the current node's value is strictly within the `minVal` and `maxVal` bounds. If not, it's invalid, return false.
3.  **Recursive Calls**:
    *   Recursively call for the left child. The new upper bound becomes the current node's value.
    *   Recursively call for the right child. The new lower bound becomes the current node's value.
4.  **Initial Call**: Start the process from the root with `Long.MIN_VALUE` and `Long.MAX_VALUE` as initial bounds. This covers all possible integer values.

## Complexity

*   **Time Complexity**: O(N), where N is the number of nodes in the tree. Each node is visited exactly once.
*   **Space Complexity**: O(H), where H is the height of the tree. This is due to the recursion stack. In the worst case (a skewed tree), H can be N, leading to O(N) space. In the best case (a balanced tree), H is log N, leading to O(log N) space.

## Review

The code is clean and correctly implements the recursive BST definition. Using `long` for `minVal` and `maxVal` is crucial. This prevents integer overflow when node values are `Integer.MIN_VALUE` or `Integer.MAX_VALUE`. The base case for null nodes and the bound updates in recursive calls are handled correctly.

## Improvements

The accepted solution is already optimal in terms of time and space complexity. No significant algorithmic improvements can be made.

## Takeaways

*   Understand the recursive definition of a Binary Search Tree (BST).
*   Use range bounds (min/max) during recursive tree traversals to enforce structural constraints.
*   Handle integer limits (`Integer.MIN_VALUE`, `Integer.MAX_VALUE`) by using wider data types like `long` for bounds.
*   Practice Depth-First Search (DFS) traversal patterns for tree validation.

## Where it applies

This problem highlights fundamental concepts in **Binary Trees** and **Binary Search Trees (BSTs)**. The solution uses **Depth-First Search (DFS)** and **Recursion** with parameter passing to maintain state.

In **real systems**, BSTs and their variants are used for:
*   **Database indexing**: For efficient data storage and retrieval.
*   **Symbol tables**: In compilers and interpreters.
*   **Any application requiring efficient sorted data operations.**

This pattern of recursive validation with bounds is useful for many **LeetCode problems** involving trees, such as:
*   Search in a Binary Search Tree
*   Kth Smallest Element in a BST
*   Lowest Common Ancestor of a Binary Search Tree
*   Convert Sorted Array to Binary Search Tree