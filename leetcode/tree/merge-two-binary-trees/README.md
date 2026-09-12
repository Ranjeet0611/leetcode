## Problem
Merge two binary trees into a new one. If nodes overlap, sum their values. If only one tree has a node at a position, use that node.

## Approach
This solution uses a recursive Depth-First Search (DFS).
A helper function merges two nodes and their subtrees.

**Base Cases:**
- If both input nodes are null, return null.
- If only one node is null, return the non-null node.

**Recursive Step:**
- If both nodes exist, create a new node.
- Its value is the sum of the input node values.
- Recursively merge the left children for the new node's left child.
- Recursively merge the right children for the new node's right child.
- Return the newly created merged node.

## Complexity
**Time:** O(N), where N is the total number of nodes in the larger of the two input trees. Each node is visited at most once.
**Space:** O(H), where H is the maximum height of the merged tree. This space is used by the recursion stack. In the worst case (a skewed tree), H can be N. O(N) space is also used to construct the new merged tree itself.

## Review
The solution is well-structured, correct, and easy to understand.
It correctly handles all scenarios for merging nodes, including null branches.
The recursive approach is natural and efficient for this problem.
The code adheres to standard practices.

## Improvements
The accepted solution is already optimal for this problem.
It achieves the best possible time complexity of O(N).
Every relevant node must be visited to construct the new merged tree.
No significant algorithmic improvements are necessary or possible.

## Takeaways
- Recursive Depth-First Search (DFS) is a natural fit for many binary tree problems.
- Careful handling of `null` nodes is crucial for base cases in tree recursion.
- Creating a "new binary tree" means constructing new nodes, not modifying inputs.
- Understand how tree height impacts recursion stack space (O(H)).

## Where it applies
**Data Structures/Patterns:**
- **Binary Trees:** Fundamental hierarchical data structure.
- **Recursion:** Solving problems by breaking them into smaller, self-similar subproblems.
- **Depth-First Search (DFS):** A tree traversal strategy that explores branches fully before backtracking.

**When to reach for them:**
- When traversing, transforming, or constructing new tree structures.
- When a problem's solution for a node depends on its children's solutions.
- For tasks like configuration merging or hierarchical data synchronization.

**Similar LeetCode Problems:**
- Invert Binary Tree
- Same Tree
- Symmetric Tree
- Maximum Depth of Binary Tree