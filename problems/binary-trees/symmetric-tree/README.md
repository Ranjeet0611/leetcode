# 101. Symmetric Tree

## Problem
This task verifies if a binary tree is symmetric around its center. We are given the node definition structure, and we must confirm the left side mirrors exactly onto the right side at every level.

## Approach
Use **Recursive Depth-First Search (DFS)** to check the mirror property. For each node, recursively compare the `left` child with the right's `right`, and then `right` with `left`. Verify these recursive steps match.

## Complexity
*   **Time Complexity:** O(N). We visit every node once.
*   **Space Complexity:** O(H). Stack depth depends on tree height.

## Review
The solution handles null nodes correctly by returning true only if both sides are empty, or false if one is missing. It confirms value equality and recurses into child pairs to validate symmetry throughout the tree structure.

## Improvements
The accepted solution is already optimal. The O(N) time complexity is the lower bound since every node must be checked for symmetry. No further optimizations are necessary.

## Takeaways
*   **Time Efficiency:** Visit each node exactly once during traversal.
*   **Space:** Recursion stack grows with tree depth (O(H)).
*   **Symmetry Logic:** Both subtrees must match perfectly at every recursive call.
*   **Scalability:** Works efficiently for deep and wide trees in Java.