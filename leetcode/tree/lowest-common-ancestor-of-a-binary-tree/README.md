## Problem
Find the Lowest Common Ancestor (LCA) for two given nodes, `p` and `q`, in a binary tree.

## Approach
This solution uses a recursive, post-order traversal.
A helper function `solve` explores the tree.
Base cases: If `root` is null, `p`, or `q`, return `root`.
Recursively call `solve` on the left and right children.
If both left and right calls return non-null, the current `root` is the LCA.
If only one call returns non-null, propagate that result upwards.
If both return null, propagate null.

## Complexity
Time: O(N), where N is the number of nodes. Each node is visited at most once.
Space: O(H), where H is the height of the tree. This is for the recursion stack.
In the worst case (skewed tree), space is O(N).
In the best case (balanced tree), space is O(log N).

## Review
The code is clean, concise, and correct.
It implements the standard recursive LCA algorithm effectively.
The logic for base cases and combining subtree results is sound.
Variable names are clear and self-explanatory.

## Improvements
The accepted solution is already optimal.
It achieves O(N) time and O(H) space complexity.
No significant algorithmic improvements are possible for a general binary tree.
Minor stylistic changes would not alter efficiency or clarity.

## Takeaways
*   **Recursive Post-Order Traversal:** Ideal when child results inform parent decisions.
*   **Divide and Conquer:** Break problems into smaller, self-similar subproblems.
*   **Crucial Base Cases:** Essential for correct recursion termination.
*   **LCA Logic:** If `p` and `q` are in different subtrees, the current node is LCA. If one is an ancestor, that ancestor is the LCA.
*   **Efficiency:** This approach provides optimal time complexity.

## Where it applies
This problem demonstrates fundamental tree and recursion concepts.

**Data Structures & Algorithms:**
*   **Binary Trees:** Understanding tree structure and traversal.
*   **Recursion:** Solving problems by breaking them down.
*   **Post-order Traversal:** Processing child information before the parent.

**When to reach for them:**
*   When you need to aggregate information from children nodes upwards.
*   For finding common ancestors or paths in hierarchical data.
*   Problems where a node's solution depends on its children's solutions.

**Similar LeetCode problems:**
*   235. Lowest Common Ancestor of a Binary Search Tree
*   1676. Lowest Common Ancestor of a Binary Tree IV
*   1650. Lowest Common Ancestor of a Binary Tree III
*   1123. Lowest Common Ancestor of Deepest Leaves