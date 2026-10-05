# 437. Path Sum III

## Problem
Find the number of paths in a binary tree that sum up to a given target value. Paths do not need to start at the root or end at a leaf. They must go downwards.

## Approach
The accepted solution uses a brute-force Depth-First Search (DFS).
It has two main recursive functions.
The first function, `pathSum`, iterates through every node in the tree. For each node, it considers it as a potential starting point for a path.
The second helper function, `solve`, performs a DFS downwards from that starting node. It tracks the remaining sum needed. If the remaining sum matches the current node's value, a valid path is found.
This means `pathSum` effectively calls `solve` for every node, exploring all downward paths from each.

## Complexity
*   **Time:** O(N^2)
    *   The `pathSum` function visits all N nodes. For each node, the `solve` helper might traverse up to N nodes in its subtree. This leads to N * O(N) operations.
*   **Space:** O(H)
    *   This is due to the recursion stack depth. In the worst case (a skewed tree), the height H can be N, making it O(N).

## Review
The code is functional for LeetCode.
Using a global `result` variable is simple but generally discouraged in production code. It can cause issues in multi-threaded environments or if not reset.
The use of `long` for sums in the `solve` function is good. This prevents integer overflow, as path sums can exceed `Integer.MAX_VALUE`.
The separation into two functions (`pathSum` and `solve`) makes the logic clear.
Base cases for null nodes are handled correctly.

## Improvements
The accepted solution is not optimal in terms of time complexity.
A more efficient approach exists that achieves O(N) time. This involves using prefix sums combined with a hash map.

## Takeaways
*   **Prefix Sums:** Useful for finding sums of paths or subarrays. They convert range sum queries into point lookups.
*   **Hash Maps:** Provide O(1) average-time lookups. Ideal for storing and retrieving frequencies of prefix sums.
*   **DFS with Backtracking:** When using a data structure (like a hash map) to track state during DFS, remember to "undo" changes when returning from a recursive call. This keeps the state correct for sibling branches.
*   **Handling Zero Prefix Sum:** Initialize the prefix sum map with `(0L, 1)`. This correctly counts paths that start directly from the root and sum to the target.
*   **Integer Overflow:** Always consider using `long` for sums if intermediate values might exceed `Integer.MAX_VALUE` or `Integer.MIN_VALUE`.

## Where it applies
This problem highlights key data structures and algorithmic patterns:

*   **Data Structures:**
    *   **Binary Trees:** For hierarchical data.
    *   **Hash Maps:** For efficient key-value storage and frequency counting.
*   **Algorithms:**
    *   **Depth-First Search (DFS):** A core tree/graph traversal.
    *   **Recursion:** Breaking problems into smaller, similar subproblems.
    *   **Prefix Sums:** Efficiently calculating sums over ranges.

Reach for these patterns when:
*   You need to traverse a tree or graph (DFS, Recursion).
*   You need to find sub-structures (paths, subarrays) with a specific sum or property (Prefix Sums, Hash Maps).
*   You need fast lookups for frequencies or existence of values (Hash Maps).

Similar LeetCode problems:
*   **Subarray Sum Equals K (560):** A classic array problem using prefix sums and a hash map.
*   **Path Sum (112), Path Sum II (113):** Simpler path sum problems in trees.
*   **Binary Tree Maximum Path Sum (124):** Involves calculating path sums with different constraints.