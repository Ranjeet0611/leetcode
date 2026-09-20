# 199. Binary Tree Right Side View

## Problem
Find the values of nodes visible from the right side of a binary tree. The output should be ordered from top to bottom.

## Approach
The accepted solution uses Breadth-First Search (BFS), also known as Level Order Traversal. It processes the tree level by level. For each level, it identifies and stores the value of the last node processed. Since BFS processes nodes from left to right within a level, the last node encountered is always the rightmost one.

## Complexity
- **Time Complexity**: O(N)
  - Each node is visited and processed exactly once. N is the number of nodes.
- **Space Complexity**: O(W)
  - The queue stores nodes at the widest level of the tree. W is the maximum width. In the worst case (complete tree), W can be O(N).

## Review
The code is well-structured and readable. It correctly implements the BFS algorithm. It handles an empty tree gracefully. Using `queue.size()` to manage level-by-level processing is a standard and effective pattern. The logic correctly identifies the rightmost node for each level.

## Improvements
The accepted solution is already highly efficient and optimal. It achieves the best possible time and space complexity for a BFS approach. No further algorithmic optimizations are needed. An alternative optimal approach using Depth-First Search (DFS) is also possible, which might offer slightly better average-case space complexity (O(H) where H is tree height).

## Takeaways
- **Breadth-First Search (BFS)**: A core algorithm for level-order tree traversal.
- **Level-by-Level Processing**: Use `queue.size()` at the start of each level's iteration to process nodes one level at a time.
- **Identifying Rightmost Node**: In BFS, the last node processed for any given level is the rightmost node visible from the right side.
- **Queue Data Structure**: Essential for BFS to maintain the First-In, First-Out (FIFO) order of node processing.

## Where it applies
This problem demonstrates **Binary Trees** and the **Breadth-First Search (BFS)** traversal pattern. The **Queue** data structure is fundamental for BFS.

Reach for these patterns when:
- You need to process a tree or graph level by level.
- You are looking for the shortest path in an unweighted graph.
- You need to explore all neighbors at a current "depth" before moving to the next.

Similar LeetCode problems:
- 102. Binary Tree Level Order Traversal
- 637. Average of Levels in Binary Tree
- 515. Find Largest Value in Each Tree Row
- 116. Populating Next Right Pointers in Each Node