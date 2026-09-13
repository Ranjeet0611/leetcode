## Problem
Find all root-to-leaf paths in a binary tree. Each path should be represented as a string.

## Approach
The accepted solution uses a Depth-First Search (DFS) approach. It recursively traverses the tree. A `currentPath` string is built as the traversal goes deeper. When a leaf node is found, the `currentPath` is added to a `result` list. For non-leaf nodes, the node's value and "->" are appended to the `currentPath` before recursing.

## Complexity
*   **Time Complexity:** O(N * L), where N is the number of nodes and L is the maximum path length. Each node is visited once. However, Java's `String` concatenation (`+=`) creates new `String` objects. Building a path of length L can take O(L^2) due to repeated copying. This makes the overall time O(N * L).
*   **Space Complexity:** O(N * L). The `result` list stores up to N/2 paths, each potentially of length L. The recursion stack depth can be O(H) (tree height), which is O(N) in a skewed tree. Each stack frame holds a `currentPath` string, contributing to O(L) space per frame. The total space is dominated by storing the result paths.

## Review
1.  **Inefficient String Concatenation:** Repeated `currentPath += ...` is a major performance bottleneck. `String` objects are immutable in Java. Each `+=` creates a new `String`, copying previous content. This leads to quadratic time complexity for building a single path.
2.  **Unused Global Variables:** The solution includes global `StringBuilder sb` and `List<String> result` variables that are not used by the core `solve` method. This is dead code and poor practice.
3.  **Redundant Parameter Initialization:** The global `result` variable is redundant as the `result` list is correctly initialized and passed as a local parameter.

## Improvements
1.  **Use `StringBuilder` for Path Construction:** Replace `String currentPath` with `StringBuilder currentPath`. `StringBuilder` is mutable and designed for efficient string manipulation, avoiding costly intermediate `String` objects.
2.  **Remove Global Variables:** Eliminate unused global `result` and `StringBuilder sb`. All necessary state should be passed as parameters or initialized locally.
3.  **Refine Base Case:** Add an explicit check for `root == null` at the beginning of the `binaryTreePaths` method for clarity.

## Takeaways
1.  **DFS for Tree Traversal:** Recursive DFS is a natural and effective way to explore all paths from root to leaves in a tree.
2.  **String Immutability vs. Mutability:** Understand the performance difference between `String` concatenation (`+=`) and `StringBuilder` for dynamic string construction in Java. `StringBuilder` is crucial for performance when building strings iteratively or recursively.
3.  **Backtracking with `StringBuilder`:** When using a mutable object like `StringBuilder` in recursive DFS, it's essential to implement backtracking (e.g., using `setLength()`) to revert the object's state after a recursive call returns. This ensures correct state for sibling branches.
4.  **Avoiding Global State:** Prefer passing necessary data as parameters or initializing it locally rather than relying on global class members.

## Where it applies
This problem demonstrates fundamental concepts in tree traversal and string manipulation:
*   **Tree Traversal (DFS):** The core pattern of visiting nodes and exploring their children recursively is a cornerstone of many tree algorithms.
    *   When to reach for it: Exploring all nodes, finding paths, calculating properties like height or sum.
    *   Similar problems: Path Sum, Sum Root to Leaf Numbers, Maximum Depth of Binary Tree, Symmetric Tree.
*   **Recursion:** The solution is a classic example of recursion, breaking a problem into smaller, similar subproblems.
    *   When to reach for it: Naturally recursive data structures (trees, graphs), divide and conquer problems.
*   **Pathfinding in Trees:** This specific problem is a simple form of pathfinding.
    *   When to reach for it: Problems involving paths from root to leaf or between specific nodes with certain properties.
*   **`StringBuilder` for Dynamic String Construction:** The use of `StringBuilder` is a common optimization in Java for scenarios where strings are built incrementally.
    *   When to reach for it: Repeated string modifications, parsing, logging, or generating complex output.