# 114. Flatten Binary Tree to Linked List

## Problem

Transform a binary tree into a "linked list". The list should follow the tree's pre-order traversal. Each node's `right` child points to the next node. All `left` children must be `null`.

## Approach

The accepted solution uses a recursive pre-order traversal. It collects all tree nodes into a `Stack`. After the stack is populated, nodes are popped one by one. This gives a reverse pre-order sequence. The "linked list" is then built from tail to head. Each popped node's `left` child is set to `null`. Its `right` child points to the previously processed node.

## Complexity

*   **Time Complexity:** O(N), where N is the number of nodes. Each node is visited once for traversal and once for list reconstruction.
*   **Space Complexity:** O(N), where N is the number of nodes. This is due to storing all nodes in the `Stack` in the worst case (e.g., a skewed tree). The recursion call stack also contributes O(N) in the worst case.

## Review

The code is clear and well-structured. It correctly implements the stack-based pre-order traversal. A helper method cleanly separates the traversal logic. Edge cases like an empty tree are handled. Variable names are descriptive. The solution is functionally correct.

## Improvements

The accepted solution uses O(N) extra space. The problem's follow-up often asks for an in-place solution with O(1) extra space. This can be achieved without an explicit stack or deep recursion.

## Optimized Approach

An O(1) extra space solution uses an iterative, in-place modification. It processes the tree in a pre-order fashion. For each `current` node:
1.  If `current` has a `left` child:
    a.  Find the rightmost node (`predecessor`) in the `current.left` subtree.
    b.  Connect `predecessor.right` to `current.right`. This appends the original right subtree after the flattened left subtree.
    c.  Set `current.right = current.left`. This moves the left subtree to become the new right subtree.
    d.  Set `current.left = null`.
2.  Move `current` to its new `right` child to continue the process.

This approach modifies the tree structure directly without extra memory.

## Takeaways

*   **Pre-order Traversal:** Essential for problems requiring a specific node processing order (Root -> Left -> Right).
*   **Stack for Traversal:** Useful for iterative tree traversals, especially when building a result in reverse order.
*   **In-place Modification:** A common optimization challenge. It involves carefully manipulating pointers to reuse existing nodes and avoid extra space.
*   **Morris Traversal Pattern:** The O(1) space solution is a variation. It uses temporary links to navigate without a stack, often restoring or leaving the structure modified.

## Where it applies

*   **Data Structures:** Binary Trees, Linked Lists. Understanding tree node manipulation and pointer re-assignment is key.
*   **Patterns:**
    *   **Tree Traversal:** Fundamental for many tree algorithms.
    *   **In-place Modification:** When memory constraints are strict.
    *   **Morris Traversal:** For O(1) space tree operations.
*   **When to reach for them:**
    *   When a specific linear order of tree nodes is required.
    *   When memory usage must be minimized for tree transformations.
    *   For tasks like serializing tree structures or processing nodes in a specific sequence.
*   **Similar LeetCode Problems:**
    *   94. Binary Tree Inorder Traversal
    *   144. Binary Tree Preorder Traversal
    *   99. Recover Binary Search Tree
    *   230. Kth Smallest Element in a BST