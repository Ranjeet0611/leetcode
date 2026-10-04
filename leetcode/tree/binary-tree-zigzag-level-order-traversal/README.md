# 103. Binary Tree Zigzag Level Order Traversal

## Problem
Traverse a binary tree. Collect node values level by level. Alternate the order of values for each level. The first level is left-to-right, the second is right-to-left, and so on.

## Approach
This solution uses Breadth-First Search (BFS). It processes the tree level by level. A boolean flag `leftToRight` tracks the current direction.

For each level:
1.  It iterates through all nodes currently in the queue.
2.  It uses a `Deque` (double-ended queue) to store node values for the current level.
3.  If `leftToRight` is true, values are added to the end of the `Deque`.
4.  If `leftToRight` is false, values are added to the front of the `Deque`. This builds the level in reverse order efficiently.
5.  Children of processed nodes are added to the main queue for the next level.
6.  The `Deque` is converted to a list and added to the final result.
7.  The `leftToRight` flag is toggled for the next level.

## Complexity
*   **Time Complexity:** O(N), where N is the number of nodes. Each node is visited and processed exactly once.
*   **Space Complexity:** O(W) in the worst case, where W is the maximum width of the tree. This space is for the queue. In a complete tree, W can be O(N). The result list also stores O(N) values.

## Review
The accepted solution is clear and well-structured. It correctly handles an empty tree. Using a `Deque` is an elegant way to achieve the zigzag pattern without explicit list reversals. Variable names are descriptive, making the logic easy to follow.

## Improvements
The solution is already highly optimized. It is idiomatic for this problem. No significant algorithmic improvements are necessary. A minor stylistic point could be using `ArrayDeque` instead of `LinkedList` for slightly better constant-factor performance if only `Deque` operations are needed. However, `LinkedList` is perfectly valid here.

## Takeaways
*   **Breadth-First Search (BFS)** is ideal for level-order tree traversals.
*   A **`Deque` (double-ended queue)** is very useful for problems needing insertions/deletions from both ends. This includes zigzag traversals or sliding window problems.
*   To process nodes level by level in BFS, capture the queue's `size` at the start of each level's loop.
*   In Java, `LinkedList` implements both `List` and `Deque`, offering flexibility.

## Where it applies
This problem highlights key concepts in tree traversal and data structure usage.

**Data Structures and Patterns:**
*   **Binary Trees**: For hierarchical data.
*   **Queues**: Fundamental for BFS, processing elements FIFO.
*   **Deques (Double-Ended Queues)**: When flexible additions/removals from both ends are needed.
*   **Breadth-First Search (BFS)**: Exploring nodes level by level, often for shortest paths in unweighted graphs.
*   **Level Order Traversal**: A specific BFS application for trees.

**When to reach for them:**
*   Displaying hierarchical data (e.g., organizational charts).
*   Finding shortest paths in unweighted graphs.
*   Processing data in layers or levels.
*   Any scenario requiring flexible queue/stack operations.

**Related LeetCode Problems:**
*   **102. Binary Tree Level Order Traversal**: Basic BFS for trees.
*   **107. Binary Tree Level Order Traversal II**: Same as 102, but levels returned in reverse order.
*   **199. Binary Tree Right Side View**: Find the last node at each level.
*   **637. Average of Levels in Binary Tree**: Calculate the average of node values per level.