# 235. Lowest Common Ancestor of a Binary Search Tree

## Problem
Find the lowest common ancestor (LCA) of two given nodes in a Binary Search Tree (BST). The LCA is the deepest node that has both `p` and `q` as descendants.

## Approach
The accepted solution uses a general recursive approach for any binary tree. It performs a depth-first search (DFS). It finds `p` and `q` in subtrees. If they are in different subtrees, the current root is the LCA. If both are in one subtree, the LCA is in that subtree.

However, a more efficient approach leverages the Binary Search Tree (BST) property. In a BST, all left descendants are smaller than the root, and all right descendants are larger.

We can traverse the tree iteratively from the root:
1.  If both `p` and `q` values are less than the current `root`'s value, the LCA must be in the left subtree. Move to `root.left`.
2.  If both `p` and `q` values are greater than the current `root`'s value, the LCA must be in the right subtree. Move to `root.right`.
3.  Otherwise, the current `root` is the LCA. This covers cases where `p` and `q` are on opposite sides of the `root`, or when `root` itself is `p` or `q`.

This iterative approach avoids unnecessary subtree traversals.

## Complexity
**Accepted Solution (General Binary Tree):**
*   **Time:** O(N), where N is the number of nodes. Every node might be visited.
*   **Space:** O(H), where H is the height of the tree. This is for the recursion stack. H can be N in the worst case (skewed tree).

**Optimized Solution (BST-specific):**
*   **Time:** O(H), where H is the height of the tree. We traverse a single path from the root to the LCA. In a balanced BST, H is log N. In a skewed BST, H can be N.
*   **Space:** O(1), as the iterative approach uses constant extra space.

## Review
The accepted solution is correct and well-structured for a general binary tree. It's concise and readable. However, it does not utilize the specific ordering property of a Binary Search Tree. This means it might perform more work than necessary for this particular problem.

## Improvements
The accepted solution is not optimal for a Binary Search Tree. By leveraging the BST property (left < root < right), we can determine the search direction at each node. This allows us to find the LCA by traversing a single path down the tree, rather than potentially exploring both subtrees. An iterative implementation further reduces space complexity.

## Takeaways
*   **Leveraging Data Structure Properties:** Always consider if specific properties of a data structure (like BST's ordering) can optimize a general algorithm.
*   **Iterative vs. Recursive Solutions:** Recursive solutions are often elegant but can incur O(H) space. Iterative solutions, when possible, can achieve O(1) space for tree traversals.
*   **LCA Logic:** The core idea is to find the deepest node that is an ancestor to both target nodes. In a BST, this means finding the split point where `p` and `q` diverge.

## Where it applies
This problem highlights **tree data structures** and **tree traversal algorithms**. The optimization for BSTs emphasizes using data structure invariants.

**Data Structures/Patterns:**
*   **Binary Search Trees (BSTs):** When data needs to be stored in a sorted manner for efficient search, insertion, and deletion.
*   **Tree Traversal (Iterative/Recursive):** For visiting nodes in a tree. Iterative traversal is often preferred for space efficiency.

**Similar LeetCode problems:**
*   **236. Lowest Common Ancestor of a Binary Tree:** The general binary tree version, which the accepted solution for this problem actually solves.
*   **98. Validate Binary Search Tree:** Checks if a tree adheres to BST properties.
*   **450. Delete Node in a BST:** Requires understanding BST structure for modification.
*   **701. Insert into a Binary Search Tree:** Another fundamental BST operation.