# Symmetric Tree

## Problem

This task involves determining if a given binary tree is symmetric. A tree is symmetric if the left subtree matches its right subtree in reverse order and both are identical. The goal is to verify balance without modifying the structure of the data, just checking for structural symmetry.

## Approach

We can use Recursive Depth-First Search (DFS). For two trees `left` and `right`:
1.  If either child is null, they must not exist in one pair, but return true if both are null.
2.  Compare the values at each position (`left.val != right.val`) and return false immediately if mismatch.
3.  Recursively check if left matches right's reflection: `solve(left.left, right.right)` and `solve(left.right, right.left)`.

## Complexity

*   **Time:** O(n). We visit every node once.
*   **Space:** O(h), where h is the height of the tree (stack depth for recursion).

## Review

The recursive solution is efficient and follows standard practice. It handles edge cases like empty trees by returning true immediately if both children are null or false if mismatched. The complexity class allows linear time traversal, which is optimal for a standard DFS algorithm in this scenario. We have not added extra steps to improve the logic further as recursion achieves best performance here without StackOverflow risk in deep balanced trees.

## Improvements

No algorithmic improvement required. Iterative approaches might reduce stack overhead but do not change asymptotic complexity (O(n)). The current recursive solution is already optimal for this specific tree problem (Symmetry Check).

## Takeaways

1.  **Linearity:** Time complexity remains O(n) with any traversal method that processes nodes individually.
2.  **Clean Solution:** Recursive code is clean and standard for easy tree problems.
3.  **Stability:** Iterative DFS improves stability by avoiding potential stack overflow in deeply unbalanced trees, even though asymptotic complexity stays the same.