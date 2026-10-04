# 102. Binary Tree Level Order Traversal

## Problem
Traverse a binary tree. Return node values grouped by level. The output should be a list of lists.

## Approach
This solution uses a Breadth-First Search (BFS) algorithm. It processes the tree level by level.

1.  A queue stores nodes to visit.
2.  Start by adding the root to the queue. Handle an empty tree as an edge case.
3.  Loop while the queue is not empty.
4.  In each iteration, get the current queue size. This size represents all nodes at the current level.
5.  Create a temporary list for the current level's node values.
6.  Iterate `size` times:
    *   Dequeue a node.
    *   Add its value to the temporary list.
    *   Enqueue its non-null left child.
    *   Enqueue its non-null right child.
7.  After the inner loop, add the temporary list to the final result list.
8.  Repeat until the queue is empty.

## Complexity
*   **Time Complexity:** O(N), where N is the number of nodes. Each node is enqueued and dequeued once.
*   **Space Complexity:** O(W) for the queue in the worst case, where W is the maximum width of the tree. This can be O(N) for a complete binary tree. The result list also stores O(N) values.

## Review
The code is clear, correct, and follows standard practices. It correctly handles an empty tree. Using `queue.size()` to delineate levels is a standard and effective BFS technique. Variable names are descriptive.

## Improvements
The solution is already optimal in terms of time and space complexity. No significant algorithmic or structural improvements are necessary.

## Takeaways
*   **Breadth-First Search (BFS):** Ideal for level-by-level tree traversal.
*   **Queue Usage:** A `Queue` is fundamental for BFS, ensuring nodes are processed in FIFO order.
*   **Level Delimitation:** Capturing `queue.size()` at the start of each outer loop iteration is key to grouping nodes by level.

## Where it applies
This BFS pattern with level-by-level processing is very common.

**Data Structures and Patterns Used:**
*   **Breadth-First Search (BFS):** Explores nodes level by level.
*   **Queue:** The core data structure for managing nodes in BFS.
*   **Binary Trees:** The specific graph structure being traversed.

**When to reach for them:**
*   When you need to process nodes level by level.
*   When finding the shortest path in an unweighted graph.

**Similar LeetCode Problems:**
*   **107. Binary Tree Level Order Traversal II:** Return levels from bottom to top.
*   **103. Binary Tree Zigzag Level Order Traversal:** Traverse levels alternating direction.
*   **199. Binary Tree Right Side View:** Return values visible from the right side.
*   **637. Average of Levels in Binary Tree:** Calculate the average value for each level.