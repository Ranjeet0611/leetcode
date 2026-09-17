# 404. Sum of Left Leaves

## Problem
Calculate the sum of all left leaf nodes in a given binary tree.

## Approach
The accepted solution uses a Breadth-First Search (BFS) traversal. It processes the tree level by level. A queue stores nodes to visit. For each node, it checks if its left child exists and is a leaf node. If so, the left child's value is added to a running sum. Then, both left and right children are added to the queue for future processing. This continues until all nodes are visited.

## Complexity
*   **Time**: O(N), where N is the number of nodes. Each node is visited once.
*   **Space**: O(W), where W is the maximum width of the tree. In the worst case (e.g., a complete binary tree), this can be O(N). In a skewed tree, it's O(1).

## Review
The solution is correct and effectively solves the problem. It uses a standard BFS approach. The logic for identifying left leaves and summing their values is accurate. The code is readable. The problem constraints ensure the initial `root` is never null.

## Improvements
The accepted BFS solution is already optimal in terms of time complexity. No further algorithmic optimization is needed. A recursive Depth-First Search (DFS) is an equally optimal alternative. A minor stylistic improvement would be to use `nullptr` instead of `NULL` for pointer comparisons in C++.

## Takeaways
This problem demonstrates fundamental tree traversal techniques. Both BFS and DFS are applicable. It shows how to identify specific node types, like leaf nodes, and apply conditional logic during traversal. The choice between BFS and DFS often depends on specific problem requirements or space considerations for different tree shapes.

## Where it applies
This problem uses **Binary Trees** and **Tree Traversal** (BFS/DFS). These patterns are fundamental:
*   **File Systems**: Representing directories and files.
*   **Organizational Charts**: Modeling hierarchical structures.
*   **Compilers**: Building Abstract Syntax Trees (ASTs).
*   **Network Routing**: Analyzing network topologies.

**Related LeetCode Problems**:
*   Binary Tree Level Order Traversal (102)
*   Maximum Depth of Binary Tree (104)
*   Symmetric Tree (101)
*   Path Sum (112)