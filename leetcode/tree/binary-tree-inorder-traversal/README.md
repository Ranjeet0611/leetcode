## Problem

This problem asks for an inorder traversal of a binary tree. The goal is to visit nodes in the order: left child, current node, then right child. The result should be a list of node values.

## Approach

The accepted solution uses a classic recursive approach. A private helper function `solve` performs the traversal.

1.  It first recursively calls itself on the left subtree.
2.  Then, it adds the current node's value to the result list.
3.  Finally, it recursively calls itself on the right subtree.

The base case for recursion is when a `null` node is encountered. In this case, the function simply returns.

## Complexity

*   **Time Complexity:** O(N), where N is the number of nodes. Each node is visited exactly once.
*   **Space Complexity:** O(N) in the worst case. This includes O(N) for the result list. The recursion stack can also go up to O(N) depth for a skewed tree. For a balanced tree, stack space is O(log N).

## Review

The code is clean, concise, and correctly implements the inorder traversal. Using a private helper method is good practice. The base case for recursion is handled well. Variable names are clear, making the code readable and idiomatic for tree traversals.

## Improvements

The current recursive solution is already optimal. It achieves O(N) time and O(N) space complexity. No other algorithm can perform better asymptotically. While an iterative solution using an explicit stack is possible, it offers the same Big-O complexity. Therefore, no significant algorithmic improvements are necessary.

## Takeaways

*   **Inorder Traversal:** Understand the "Left -> Root -> Right" sequence. This is fundamental for many tree problems.
*   **Recursive Tree Traversal:** Recursion is a natural and elegant way to process trees due to their self-similar structure.
*   **Base Cases:** Always define clear base cases (e.g., `null` nodes) to terminate recursion correctly.
*   **Recursion Stack Space:** Be aware that recursion uses stack space. In worst-case scenarios (skewed trees), this can lead to O(N) space complexity.

## Where it applies

Inorder traversal is a core concept for binary trees.

**Data Structures and Patterns:**

*   **Binary Trees:** The primary data structure.
*   **Recursion:** The main algorithmic pattern used for tree traversals.
*   **Stack:** Used for iterative tree traversal solutions, simulating recursion.

**When to reach for them:**

*   **Binary Search Trees (BSTs):** Inorder traversal of a BST yields elements in sorted order. This is crucial for validation and retrieval.
*   **Expression Trees:** To reconstruct infix expressions.
*   **Compilers:** For processing Abstract Syntax Trees (ASTs).
*   **Hierarchical Data:** For processing data in a specific order.

**Related LeetCode Problems:**

*   **98. Validate Binary Search Tree:** Inorder traversal helps check if elements are sorted.
*   **105. Construct Binary Tree from Preorder and Inorder Traversal:** Requires understanding both traversal properties.
*   **106. Construct Binary Tree from Inorder and Postorder Traversal:** Similar reconstruction problem.
*   **144. Binary Tree Preorder Traversal / 145. Binary Tree Postorder Traversal:** Other fundamental tree traversals.