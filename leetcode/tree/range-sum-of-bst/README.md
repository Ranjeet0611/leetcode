# 938. Range Sum of BST

## Problem
Sum all node values in a Binary Search Tree (BST) that fall within a given inclusive range `[low, high]`.

## Approach
The initial solution uses a recursive Depth-First Search (DFS). It visits every node in the tree. If a node's value is within the `[low, high]` range, it adds the value to a running sum. It continues traversing both left and right children regardless of the node's value.

## Complexity
Time Complexity: O(N), where N is the number of nodes. This is because every node is visited.
Space Complexity: O(H), where H is the height of the tree. This is due to the recursion stack. In the worst case (skewed tree), H can be N, leading to O(N) space. In a balanced tree, H is log N, leading to O(log N) space.

## Review
The code is clear, concise, and correctly sums values within the range. It handles null nodes well. However, it treats the BST like a generic binary tree. It does not use the fundamental BST property to avoid unnecessary traversals. This means it performs more work than needed for a BST problem.

## Improvements
The primary improvement is to leverage the BST property to prune the search space.
- If a node's value is less than `low`, its left subtree can be skipped. All values there would be even smaller.
- If a node's value is greater than `high`, its right subtree can be skipped. All values there would be even larger.
This optimization significantly reduces the number of nodes visited, especially for narrow ranges.

## Takeaways
- **Leverage Data Structure Properties:** Always consider the specific properties of the data structure (e.g., BST property) to find optimal solutions.
- **Pruning for Efficiency:** In tree traversals, pruning branches that cannot contain relevant data is a powerful optimization.
- **Recursive DFS for Trees:** Recursive DFS is effective for trees, but careful consideration of base cases and recursive calls is essential.
- **Time Complexity (Worst vs. Average):** While worst-case complexity might remain O(N) (e.g., if the range covers the whole tree), optimizations can drastically improve average-case performance.