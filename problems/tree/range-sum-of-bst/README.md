# Range Sum of BST

## Problem
Calculate the sum of values in a Binary Search Tree (BST) within a specified range `[low, high]`.

## Approach
Recursive Depth-First Search (DFS). Traverses the BST and accumulates node values within the `[low, high]` range at each node.

## Complexity
*   **Time Complexity:** O(N) in worst case where N is the number of nodes.
*   **Space Complexity:** O(H) for recursion stack depth, up to O(N) in skewed trees.

## Review
The solution performs a standard DFS traversal checking if each node's value falls within the target range. It correctly handles null nodes and recursively sums valid values. The logic is clean and efficient enough for the given constraints (Easy difficulty). No obvious bugs found in basic structure.

## Improvements
No additional optimizations are required beyond scope constraints.

## Takeaways
1.  Recursive DFS traversal is suitable for BST Range Sum problems.
2.  Time complexity is proportional to the number of nodes checked (O(N)).
3.  Stack depth can be O(H) which depends on tree height.
4.  This solution avoids unnecessary sorting or additional data structures required by this specific problem.