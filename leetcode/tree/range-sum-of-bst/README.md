## Problem
Calculate the sum of all node values in a Binary Search Tree (BST) that fall within a specified inclusive range `[low, high]`.

## Approach
This solution uses a recursive Depth-First Search (DFS). It efficiently traverses the BST.
The key is to use BST properties to avoid unnecessary visits.

1.  **Base Case**: If a node is null, return 0.
2.  **Current Node**: If the current node's value is within `[low, high]`, add it to the sum.
3.  **Pruning**:
    *   If `root.val > low`, recursively check the left subtree. Nodes in the left subtree are smaller than `root.val`.
    *   If `root.val < high`, recursively check the right subtree. Nodes in the right subtree are larger than `root.val`.
This pruning avoids traversing branches that cannot contain valid nodes.

## Complexity
*   **Time**: O(N) in the worst case. N is the number of nodes. This happens if the range covers most nodes. On average, pruning reduces visited nodes. Each node is visited at most once.
*   **Space**: O(H) for the recursion stack. H is the height of the BST. In a skewed tree, H can be N (O(N) space). In a balanced tree, H is log N (O(log N) space).

## Review
The solution is clear, correct, and well-structured. It effectively uses recursion and BST properties.
**Strengths**: Correct logic, easy to read, efficient due to pruning, uses a clean helper method.
**Minor Suggestions**: The helper method could be explicitly `private`. The sum initialization is fine as is. These are not critical for performance or correctness.

## Improvements
The accepted solution is already optimal. No significant algorithmic improvements are possible. It correctly leverages BST properties for efficient pruning.

## Takeaways
*   **Leverage BST Properties**: Always use the `left < parent < right` property for optimization.
*   **Recursive DFS**: A natural pattern for many tree problems.
*   **Pruning for Efficiency**: Eliminate subtrees that cannot contain solutions early.
*   **Helper Methods**: Keep public APIs clean by using private helper functions for recursive logic.

## Where it applies
This problem highlights core concepts in tree traversal and Binary Search Trees.

**Data Structures and Patterns Used:**
*   **Binary Search Trees (BSTs)**: For efficient sorted data storage and retrieval.
*   **Recursion**: To break down problems into smaller, similar subproblems.
*   **Depth-First Search (DFS)**: A common tree traversal strategy.
*   **Pruning**: An optimization to reduce the search space.

**When to reach for them:**
*   When data needs to be stored in a sorted manner for quick lookups.
*   For range queries or finding elements within a specific range.
*   When traversing hierarchical data structures like trees.

**Other LeetCode Problems it Typically Unlocks:**
*   94. Binary Tree Inorder Traversal
*   98. Validate Binary Search Tree
*   230. Kth Smallest Element in a BST
*   235. Lowest Common Ancestor of a Binary Search Tree