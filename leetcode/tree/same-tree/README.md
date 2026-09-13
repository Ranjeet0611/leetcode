# 100. Same Tree

## Problem
Determine if two binary trees are identical. This means they must have the same structure and all corresponding nodes must have equal values.

## Approach
The solution uses a recursive Depth-First Search (DFS). It compares nodes `p` and `q` in parallel.
1. If both `p` and `q` are null, they match. Return `true`.
2. If only one is null, they differ. Return `false`.
3. If their values (`p.val` and `q.val`) differ, they are not the same. Return `false`.
4. Otherwise, recursively check their left subtrees AND their right subtrees.

## Complexity
**Time:** O(N). N is the number of nodes in the smaller tree. We visit each node at most once.
**Space:** O(H). H is the height of the tree. This is due to the recursion stack. In the worst case (skewed tree), H can be N. In the best case (balanced tree), H is log N.

## Review
The solution is concise and well-structured. It correctly uses recursion and handles all base cases. The code is readable and follows good practices.

## Improvements
The accepted solution is already optimal. It uses a recursive DFS approach. This efficiently compares trees in parallel. It stops early if a mismatch is found. No further algorithmic improvements are needed.

## Takeaways
- Use recursive DFS for tree traversal and comparison.
- Handle `null` nodes carefully. Both `null` means match; one `null` means mismatch.
- Combine subproblem results (left and right subtrees) using logical AND.
- Implement early exit conditions to stop processing on first mismatch.

## Where it applies
This pattern is fundamental for tree manipulation.
**Data Structures**: Binary Trees, Recursive Data Structures.
**Patterns**: Depth-First Search (DFS), Recursion, Tree Traversal.
**When to reach for them**: When comparing two tree structures, or performing operations that require parallel traversal of two trees.
**Similar LeetCode Problems**:
- 101. Symmetric Tree
- 104. Maximum Depth of Binary Tree
- 112. Path Sum
- 226. Invert Binary Tree