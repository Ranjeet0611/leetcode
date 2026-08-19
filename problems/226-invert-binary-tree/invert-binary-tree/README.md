# Invert Binary Tree

A recursive method for swapping binary tree nodes logically.

## Problem
Swap left and right children recursively for every node in a binary tree structure. Easy difficulty level.

## Approach
Use Depth-First Search to traverse the tree nodes sequentially. Perform swaps at each node using temporary storage. This handles parent-child relationships easily.

## Complexity
Time: O(N). Space: O(H). This stack-based approach is optimal for recursive modification without extra memory overhead.

## Review
Code handles input correctly with minimal parameters and logic. DFS ensures proper node traversal during recursion.

## Improvements
No changes are needed. The algorithmic structure for inversion is already optimal (O(N) time, O(H) space). Standard recursion stack usage prevents auxiliary allocation issues.

## Takeaways
1. In-place recursive modification saves memory overhead efficiently.
2. Recursive DFS logic ensures clean code execution without extra allocations.