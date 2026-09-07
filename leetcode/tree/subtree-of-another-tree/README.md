# 572. Subtree of Another Tree

## Problem
Determine if a binary tree `subRoot` is a subtree of another binary tree `root`. A subtree must have the exact same structure and node values.

## Approach
The correct approach uses two recursive functions.
First, a helper function `isSameTree(p, q)` checks if two trees are identical. It returns `true` if both are `null`, `false` if one is `null` and the other isn't, or if their values differ. Otherwise, it recursively checks their left and right subtrees.
Second, the main `isSubtree(root, subRoot)` function. It first checks if `subRoot` is `null` (always a subtree) or if `root` is `null` (and `subRoot` isn't). Then, it calls `isSameTree(root, subRoot)` to see if the current `root` matches `subRoot`. If not, it recursively calls `isSubtree` on `root.left` OR `root.right` to search deeper.

## Complexity
*   **Time:** O(N * M). N is the number of nodes in `root`, M is in `subRoot`. The `isSubtree` function visits each of N nodes. For each `root` node, `isSameTree` might traverse all M nodes of `subRoot`.
*   **Space:** O(max(N, M)). This is due to the maximum depth of the recursion stack for both `root` and `subRoot` traversals.

## Review
The accepted solution is logically flawed. It incorrectly combines the logic for checking if two trees are identical and searching for a subtree.
When `root.val == subRoot.val`, it tries to check for identity. However, if a mismatch occurs deeper, it incorrectly attempts to search for `subRoot` within the mismatched branch.
For example, `root = [1, 1, null]` and `subRoot = [1]` should return `true`. The flawed solution returns `false`. It fails because `check(root.left=[1], subRoot.left=null)` incorrectly returns `false` instead of allowing the `isSubtree` logic to continue.

## Improvements
The main improvement is to separate the concerns into two distinct, correct recursive functions.
The `isSameTree` helper function should strictly check for exact tree identity.
The `isSubtree` function should use this helper while traversing the main tree. This separation makes the logic clear, correct, and easier to debug.

## Takeaways
*   **Divide and Conquer with Helper Functions:** Break down complex problems into smaller, well-defined sub-problems. `isSameTree` is a perfect helper for `isSubtree`.
*   **Careful Base Cases:** Correctly handle `null` nodes in tree problems. Distinguish between `(null, null)` (match) and `(null, non-null)` (mismatch).
*   **Nested Recursion Pattern:** Many tree problems involve an outer recursion to traverse the main tree and an inner recursion for specific checks at each node.
*   **Understanding Problem Constraints:** Analyze N and M to estimate complexity and determine if an O(N*M) solution is acceptable.

## Where it applies
This problem showcases fundamental tree traversal and comparison techniques.
*   **Data Structures & Algorithms:** Binary Trees, Depth-First Search (DFS), Recursion.
*   **When to reach for them:** Use these patterns when you need to compare tree structures, search for specific patterns within hierarchical data, or process all nodes in a tree.
*   **Similar LeetCode Problems:**
    *   100. Same Tree
    *   101. Symmetric Tree
    *   226. Invert Binary Tree
    *   236. Lowest Common Ancestor of a Binary Tree