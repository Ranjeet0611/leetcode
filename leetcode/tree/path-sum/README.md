# 112. Path Sum

## Problem
Checks if any root-to-leaf path in a binary tree sums to a given target value.

## Approach
This solution uses a recursive Depth-First Search (DFS). A helper function `solve` explores paths.

1.  **Base Case (Empty Node):** If the current node is `null`, no path exists. Return `false`.
2.  **Base Case (Leaf Node):** If it's a leaf node (no children) and the `targetSum` (after subtracting the current node's value) is `0`, a valid path is found. Return `true`.
3.  **Recursive Step:** For non-leaf nodes, recursively call `solve` for the left and right children. Subtract the current node's value from `targetSum` for each call. Combine results using logical OR (`||`).

## Complexity
*   **Time:** O(N), where N is the number of nodes. Each node is visited once.
*   **Space:** O(H), where H is the height of the tree. This is for the recursion stack. In the worst case (skewed tree), H can be N. In the best case (balanced tree), H is log N.

## Review
The solution is clean, correct, and uses standard tree traversal practices. The recursive helper function is effective for DFS. Base cases are handled well. The logic correctly updates `targetSum` and aggregates results.

## Improvements
The accepted solution is already optimal. No significant algorithmic improvements are possible. Every node might need to be visited in the worst case. Minor stylistic changes, like inlining the helper function, are possible but do not change performance.

## Takeaways
*   **Recursive DFS:** A powerful pattern for exploring paths in binary trees.
*   **Crucial Base Cases:** Correctly handling `null` nodes and leaf nodes is vital for recursion.
*   **State Management:** Passing `targetSum` as a parameter effectively tracks the remaining sum needed.
*   **Logical OR:** Use `||` when any valid path satisfies the condition.

## Where it applies
This problem highlights fundamental tree traversal and recursion.

*   **Data Structures:** Binary Trees.
*   **Algorithms:** Depth-First Search (DFS).
*   **When to reach for them:** When traversing hierarchical data, checking properties of paths, or searching for specific elements in trees.
*   **Similar LeetCode Problems:**
    *   Path Sum II (113)
    *   Sum Root to Leaf Numbers (129)
    *   Maximum Path Sum (124)
    *   Lowest Common Ancestor of a Binary Tree (236)