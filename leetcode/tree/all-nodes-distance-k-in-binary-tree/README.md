# 863. All Nodes Distance K in Binary Tree

## Problem

Find all nodes in a binary tree that are exactly `k` distance away from a given `target` node.

## Approach

This solution uses a two-phase Breadth-First Search (BFS) approach.

**Phase 1: Mark Parents**
First, a BFS traversal starts from the tree's root. It builds a `parentMarker` map. This map stores each node's immediate parent. This step effectively converts the tree into a graph, allowing traversal both downwards to children and upwards to parents.

**Phase 2: BFS from Target**
Next, a second BFS begins from the `target` node. A `visited` map tracks processed nodes to prevent cycles. The BFS explores nodes level by level. For each node, it checks its left child, right child, and parent. Unvisited neighbors are added to the queue. This continues until the `currentLevel` reaches `k`. All nodes remaining in the queue at this point are exactly distance `k` from the target. Their values are collected as the result.

## Complexity

**Time Complexity:** O(N), where N is the number of nodes in the binary tree.
Both BFS phases visit each node at most once.

**Space Complexity:** O(N), where N is the number of nodes in the binary tree.
The `parentMarker` map, `visited` map, and the BFS `Queue` can each store up to O(N) nodes in the worst case. The `result` list can also hold up to O(N) nodes.

## Review

The solution is well-structured and correctly solves the problem. It clearly separates the parent-marking step from the distance-finding BFS. Both BFS implementations are correct, using a queue for level-order processing and a `visited` map to handle graph traversal. The approach is efficient and handles edge cases like `k=0` correctly.

## Improvements

The accepted solution is already optimal in terms of time and space complexity. No further algorithmic improvements can reduce the asymptotic complexity. The two-phase BFS approach is the standard and most efficient way to solve this problem.

## Takeaways

*   **Tree to Graph Transformation:** For problems needing upward traversal in a tree, explicitly storing parent pointers converts the tree into a general graph. This allows bidirectional movement.
*   **BFS for Shortest Paths/Distances:** BFS is ideal for finding shortest paths or all nodes at a specific distance in unweighted graphs. It explores layer by layer.
*   **`visited` Set/Map in Graph Traversal:** Always use a `visited` set or map in graph traversals (like BFS or DFS) to prevent infinite loops and redundant work, especially when cycles are possible.
*   **Level-Order Traversal:** BFS naturally performs level-order traversal, making it easy to track distance or depth from a starting node.

## Where it applies

This solution demonstrates fundamental data structures and algorithmic patterns.

**Data Structures:**
*   **Binary Trees:** The input structure.
*   **Graphs:** The problem is solved by treating the tree as a graph with parent connections.
*   **Queues:** Essential for BFS, enabling level-order processing.
*   **Hash Maps:** Used for `parentMarker` (node to parent mapping) and `visited` (tracking visited nodes) for efficient lookups.

**Patterns:**
*   **Breadth-First Search (BFS):** The core algorithm for finding nodes at a specific distance or shortest paths in unweighted graphs.
*   **Tree Traversal:** Specifically, BFS for level-order processing.
*   **Graph Traversal:** The problem becomes a graph traversal once parent pointers are added.
*   **Parent Pointers in Trees:** A common technique to enable upward movement or treat a tree as a more general graph.

**When to reach for them:**
Use these patterns when you need to find shortest paths, nodes at a specific distance, or perform level-by-level processing in trees or unweighted graphs.

**Similar LeetCode Problems:**
*   Binary Tree Level Order Traversal (102)
*   Shortest Path in Binary Matrix (1091)
*   Rotting Oranges (994)
*   Minimum Depth of Binary Tree (111)