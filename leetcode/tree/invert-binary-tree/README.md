# 226. Invert Binary Tree

Difficulty: Easy

## Problem
Invert a binary tree. This means swapping the left and right children of every node.

## Approach
This solution uses a recursive Depth-First Search (DFS). It's a post-order traversal.
First, it recursively inverts the left subtree.
Then, it recursively inverts the right subtree.
Finally, it swaps the left and right children of the current node.
This ensures changes propagate upwards from the deepest parts of the tree.

## Complexity
*   **Time Complexity:** O(N), where N is the number of nodes. Each node is visited once.
*   **Space Complexity:** O(H), where H is the height of the tree. This is for the recursion stack. In the worst case (skewed tree), H can be N.

## Review
The code is clean, concise, and correctly implements the inversion logic. The base case for recursion (`root == null`) is handled well. Using a helper method is good practice. The post-order traversal is crucial for correctness.

## Improvements
The accepted solution is already optimal. No significant algorithmic improvements are possible for this problem. Any solution must visit every node. Minor stylistic changes are possible but won't affect performance.

## Takeaways
*   Recursive DFS is effective for many tree problems.
*   Understanding traversal orders (like post-order) is key for tree manipulations.
*   Always define a clear base case for recursion (e.g., `root == null`).
*   For tree problems, O(N) time and O(H) or O(W) space (recursion stack or queue) are typically optimal.