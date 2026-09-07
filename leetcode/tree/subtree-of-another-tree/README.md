## Problem
Given two binary trees, determine if the second tree is a subtree of the first. A subtree includes all descendants.

## Approach
This solution uses a recursive Depth-First Search (DFS).
It has two main parts:
1.  A helper function checks if two trees are identical. It compares node values and recursively checks left and right subtrees.
2.  The main function traverses the larger tree. At each node, it calls the helper to see if the subtree rooted there is identical to the smaller tree. If not, it recursively checks the left and right children.

## Complexity
*   **Time:** O(N * M). N is nodes in the main tree, M is nodes in the subtree. In the worst case, we compare the subtree at every node of the main tree.
*   **Space:** O(N + M). This is due to the recursion stack depth. It can go as deep as N levels for the main tree traversal, plus M levels for each identity check.

## Review
The code is clear and well-structured. It separates checking tree identity from traversing the main tree. Base cases are handled correctly for both recursive functions. This is a standard and readable solution for the problem.

## Improvements
The accepted solution is not strictly optimal in time complexity.
A more efficient approach uses tree serialization combined with string matching.
Serialize both trees into unique string representations, including null markers and delimiters.
Then, use an algorithm like Knuth-Morris-Pratt (KMP) to check if the smaller tree's string is a substring of the larger tree's string.
This optimized approach achieves O(N + M) time complexity.

## Takeaways
*   **Recursive Tree Traversal (DFS):** Essential for visiting all nodes in a tree.
*   **Helper Functions:** Break down complex logic into smaller, reusable parts.
*   **Base Cases:** Crucial for correct termination and handling edge cases in recursion.
*   **Time-Space Trade-offs:** Simple solutions might be less optimal but easier to implement.
*   **Tree Serialization:** Convert trees to linear structures for string/array algorithms.

## Where it applies
This problem highlights key tree concepts:
*   **Tree Traversal (DFS):** Used for exploring all nodes, like finding max depth or path sums.
*   **Tree Equality/Comparison:** Checking if two trees are identical in structure and values.
*   **Substructure Search:** Finding a specific pattern within a larger tree.
*   **Related LeetCode Problems:**
    *   100. Same Tree
    *   101. Symmetric Tree
    *   104. Maximum Depth of Binary Tree
    *   236. Lowest Common Ancestor of a Binary Tree