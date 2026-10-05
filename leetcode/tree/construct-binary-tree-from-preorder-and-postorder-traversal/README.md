# 889. Construct Binary Tree from Preorder and Postorder Traversal

## Problem

Reconstruct a binary tree. You are given its preorder and postorder traversals. If multiple valid trees exist, any one is acceptable.

## Approach

This solution uses a recursive Depth-First Search (DFS). It leverages properties of preorder (Root, Left, Right) and postorder (Left, Right, Root) traversals.

A global `preIndex` tracks the current root from `preorder`. A global `postIndex` tracks the current node to "close" from `postorder`.

1.  Create a new `TreeNode` using `preorder[preIndex]`. Increment `preIndex`.
2.  If the new node's value is not `postorder[postIndex]`, it means the node has children.
    *   Recursively build the `left` child.
    *   Check again: if the node's value is still not `postorder[postIndex]`, recursively build the `right` child.
3.  When `node.val` matches `postorder[postIndex]`, the current subtree is fully built. Increment `postIndex` to "close" this node.
4.  Return the constructed node.

This approach cleverly uses `postorder[postIndex]` as a signal to determine when a subtree is complete.

## Complexity

*   **Time:** O(N), where N is the number of nodes. Each node is created once. `preIndex` and `postIndex` advance linearly.
*   **Space:** O(N), where N is the number of nodes. This is due to the recursion stack depth in the worst case (a skewed tree).

## Review

The solution is correct and efficiently reconstructs a valid binary tree. It achieves optimal time and space complexity.

**Strengths:**
*   **Correctness:** Accurately builds a tree based on traversal properties.
*   **Efficiency:** Optimal O(N) time and space.
*   **Conciseness:** The recursive logic is compact.

**Considerations:**
*   Using global indices (`preIndex`, `postIndex`) is common in LeetCode but can be tricky in larger systems.
*   The condition `node.val != postorder[postIndex]` requires understanding the traversal interaction.

## Improvements

The provided solution is already optimal. It achieves O(N) time and O(N) space complexity. No further algorithmic improvements are necessary or possible to achieve better asymptotic performance.

## Takeaways

*   **Recursive Tree Construction:** Many tree problems are best solved with recursion (DFS).
*   **Traversal Properties:** Understand how preorder (root first) and postorder (root last) traversals reveal tree structure.
*   **Index Management:** Careful use of indices (like `preIndex`, `postIndex`) is crucial for navigating input arrays during recursion.
*   **Termination Signal:** `postorder[postIndex]` acts as a powerful signal to complete a subtree.
*   **Handling Ambiguity:** When multiple trees are valid, the solution implicitly constructs one consistent valid tree.

## Where it applies

This problem highlights fundamental concepts in **Tree** data structures and **Recursion**.

**Data Structures & Patterns:**
*   **Binary Trees:** Core understanding of tree nodes and their relationships.
*   **Depth-First Search (DFS):** The recursive solution is a classic DFS pattern.
*   **Traversal Properties:** Using the specific order of elements in traversals to infer structure.

**When to reach for them:**
*   Tree reconstruction problems.
*   Processing hierarchical data structures.
*   Any problem involving recursive exploration of a tree.

**Related LeetCode Problems:**
*   **105. Construct Binary Tree from Preorder and Inorder Traversal**
*   **106. Construct Binary Tree from Inorder and Postorder Traversal**
*   **297. Serialize and Deserialize Binary Tree**
*   **144. Binary Tree Preorder Traversal** (and other basic traversal problems)