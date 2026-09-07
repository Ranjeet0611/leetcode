## Problem

Find the longest path between any two nodes in a binary tree. This path may or may not pass through the root. The length of a path is the number of edges between nodes.

## Approach

The accepted solution uses a two-pass recursive strategy. It first defines a helper function to calculate the height of any subtree. The main function then traverses the tree. For each node, it calculates the height of its left and right subtrees. The sum of these heights is a potential diameter passing through the current node. This value updates a global maximum diameter. The function then recursively explores left and right children.

## Complexity

**Time:** O(N^2)
The `height` function is called for each node. Calculating the height of a subtree involves traversing that subtree. This leads to redundant calculations. For example, a subtree's height might be computed multiple times by different parent calls. In the worst case (a skewed tree), this results in N calls, each taking up to O(N) time.

**Space:** O(H)
This is due to the recursion stack depth. H is the height of the tree. In the worst case (a skewed tree), H can be N, leading to O(N) space. For a balanced tree, H is log N, so space is O(log N).

## Review

The solution correctly finds the diameter. However, its O(N^2) time complexity is inefficient for larger trees. For N up to 10^4, N^2 operations (10^8) can exceed typical time limits. The use of a class-level variable for `maxDia` makes the method stateful.

## Improvements

The current solution is not optimal in terms of time complexity. It can be improved from O(N^2) to O(N). This is achieved by combining the height calculation and diameter update into a single depth-first search (DFS) traversal.

The optimized approach uses one recursive DFS function. This function returns the height of the current subtree. While traversing, it recursively gets the heights of its left and right children. The sum of these two heights is a potential diameter passing through the current node. This value updates a global maximum diameter. Finally, the function returns `1 + max(leftHeight, rightHeight)` to its parent, representing the height of the current subtree.

## Takeaways

Avoid redundant computations in tree traversals. When multiple properties (like height and diameter) are needed, combine their calculations into a single DFS pass. A common pattern is for a recursive function to return one value (e.g., height) while updating another (e.g., max diameter) via a side effect (like a global variable). This transforms an O(N^2) solution into an O(N) solution by processing each node only once.

## Where it applies

This problem highlights fundamental concepts of **tree traversals (Depth-First Search, specifically post-order)** and **recursion**. The pattern of calculating subtree properties and aggregating them upwards is very common.

**When to reach for them:**
- When you need to compute a property for a node that depends on properties of its children.
- When traversing hierarchical data structures.

**Similar LeetCode problems:**
*   124. Binary Tree Maximum Path Sum
*   110. Balanced Binary Tree
*   104. Maximum Depth of Binary Tree
*   687. Longest Univalue Path