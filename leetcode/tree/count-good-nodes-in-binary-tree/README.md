# 1448. Count Good Nodes in Binary Tree

## Problem

Count "good" nodes in a binary tree. A node is "good" if its value is greater than or equal to the maximum value on the path from the root to its immediate parent.

## Approach

This solution uses a Depth-First Search (DFS) approach. A recursive helper function traverses the tree. It keeps track of the maximum value encountered so far on the path from the root to the current node's parent.

For each node:
1.  Compare its value with the current path maximum.
2.  If the node's value is greater than or equal, it's a "good" node. Increment a counter.
3.  Update the path maximum for its children. This new maximum is the current node's value if it was greater than the previous path maximum.
4.  Recursively call the helper function for both left and right children.
The initial call starts with the root and `Integer.MIN_VALUE` as the path maximum. This ensures the root node is always considered "good".

## Complexity

*   **Time:** O(N), where N is the number of nodes. Each node is visited exactly once.
*   **Space:** O(H), where H is the height of the binary tree. This is due to the recursion stack. In the worst case (skewed tree), H can be N. In the best case (balanced tree), H is log N.

## Review

The solution is clear, concise, and correctly implements the logic. Using `Integer.MIN_VALUE` for the initial path maximum correctly handles the root node. The recursive structure is well-suited for tree traversal. While a global counter is used, it's common in competitive programming and doesn't affect correctness here.

## Improvements

The accepted solution is already optimal in terms of time and space complexity. No algorithmic improvements are necessary. A minor stylistic refactoring could involve making the recursive helper function return the count of good nodes in its subtree, eliminating the need for a global counter. This would improve function purity but not algorithmic performance.

## Takeaways

*   **Depth-First Search (DFS):** A fundamental technique for exploring tree paths.
*   **State Passing in Recursion:** Pass accumulated state (like `maxValPath`) as parameters to recursive calls. This helps maintain context along a path.
*   **Base Cases:** Define clear base cases (e.g., `null` node) to terminate recursion.
*   **Root Node Handling:** Special initial values (like `Integer.MIN_VALUE`) might be needed for the root to ensure correct processing.

## Where it applies

This problem showcases core concepts of tree traversal and recursion.

*   **Data Structures/Algorithms:** Binary Trees, Depth-First Search (DFS), Recursion.
*   **When to reach for them:** Use these patterns when you need to explore paths from root to leaves, pass information down the tree, or check properties of nodes relative to their ancestors.
*   **Similar LeetCode Problems:**
    *   104. Maximum Depth of Binary Tree
    *   112. Path Sum
    *   124. Binary Tree Maximum Path Sum
    *   437. Path Sum III