## Problem

Find the k-th smallest value in a Binary Search Tree (BST). `k` is 1-indexed.

## Approach

The initial solution uses an in-order traversal. A BST's in-order traversal visits nodes in ascending order. All node values are collected into an `ArrayList`. The k-th smallest element is then retrieved from the list at index `k-1`.

## Complexity

*   **Time Complexity:** O(n). A full in-order traversal visits every node once. Adding to an `ArrayList` is amortized O(1).
*   **Space Complexity:** O(n). The `ArrayList` stores all `n` node values. Recursive calls can consume O(n) stack space in the worst case (skewed tree).

## Review

The code is clear and correctly implements the in-order traversal. It's easy to understand. It correctly handles null nodes and 1-indexed `k`. No obvious bugs were found.

## Improvements

The current solution collects all elements, which is often unnecessary. We can optimize space and potentially time. The improved approach stops the in-order traversal early. As soon as the `k`-th node is visited, its value is stored, and the traversal terminates. This avoids storing all elements in a list. It also prevents further unnecessary recursive calls.

## Takeaways

*   **BST In-order Traversal:** This traversal yields elements in sorted order. It's fundamental for problems involving order statistics in BSTs.
*   **Early Termination:** Stop processing once the desired result is found. This can significantly improve performance by avoiding redundant work.
*   **State Management in Recursion:** Use class-level fields or mutable objects to pass and update state (like a counter or result) across recursive calls.

## Where it applies

This problem highlights core BST and tree traversal concepts.

**Data Structures and Patterns:**
*   **Binary Search Trees (BSTs):** Efficiently stores ordered data. Its properties are key for sorted access.
*   **In-order Traversal:** Essential for processing BST nodes in ascending order.
*   **Recursion:** A natural way to solve tree problems due to their recursive definition.
*   **Early Exit/Optimization:** A common technique to improve algorithm efficiency.

**Related LeetCode Problems:**
*   94. Binary Tree Inorder Traversal
*   98. Validate Binary Search Tree
*   530. Minimum Absolute Difference in BST