## Problem
Calculate the sum of node values in a Binary Search Tree (BST) that fall within a specified inclusive range [low, high].

## Approach
The initial solution uses a recursive Depth-First Search (DFS). It traverses every node in the BST. For each node, it checks if its value is within the `[low, high]` range. If it is, the value is added to a running sum. This sum is stored in a global instance variable.

## Complexity
*   **Time**: O(N), where N is the number of nodes. In the worst case, all nodes are visited.
*   **Space**: O(H), where H is the height of the BST. This is due to the recursion stack. H can be O(N) for a skewed tree or O(log N) for a balanced tree.

## Review
The accepted solution has a few areas for improvement:
*   **Global Variable**: Using a global variable (`ans`) for the sum is generally poor practice. It makes the function non-reentrant and can cause issues if the object is reused.
*   **Unused Code**: An `int result = 0;` variable is declared but never used, which is dead code.
*   **No BST Pruning**: The traversal visits both left and right subtrees unconditionally. It does not leverage the BST property to skip branches that cannot contain relevant values.

## Improvements
The solution can be optimized by leveraging the BST property:
1.  **Eliminate Global Variable**: Modify the recursive function to return the sum of its subtree. This makes the function more modular and safer.
2.  **Remove Unused Code**: Delete the `int result = 0;` line.
3.  **Leverage BST Property for Pruning**:
    *   If `root.val < low`, all values in the left subtree will also be less than `low`. So, only traverse the right subtree.
    *   If `root.val > high`, all values in the right subtree will also be greater than `high`. So, only traverse the left subtree.
    *   If `root.val` is within the range, add it and then traverse both subtrees. This significantly reduces visited nodes in many cases.

## Takeaways
*   **Leverage Data Structure Properties**: Always use the specific properties of a data structure (like BST's ordered nature) to optimize algorithms.
*   **Recursive Function Design**: Prefer passing parameters and returning values in recursive functions over using global variables for accumulating results. This leads to cleaner, more robust code.
*   **Code Cleanliness**: Remove unused variables and redundant code to improve readability and maintainability.

## Where it applies
This problem highlights fundamental concepts of **Binary Search Trees (BSTs)** and **Depth-First Search (DFS) traversals**.

**Data Structures & Patterns**:
*   **Binary Search Trees**: Essential for ordered data, enabling efficient search, insertion, and range queries.
*   **Tree Traversal (DFS)**: A common way to visit all nodes in a tree.
*   **Pruning Search Space**: A critical optimization technique in search algorithms to avoid unnecessary computations.

**When to reach for them**:
*   When you need to store data in a sorted manner for quick lookups, insertions, or range-based queries.
*   When processing hierarchical data structures.

**Related LeetCode Problems**:
*   **BST Operations**: 700. Search in a Binary Search Tree, 701. Insert into a Binary Search Tree, 450. Delete Node in a BST, 230. Kth Smallest Element in a BST.
*   **BST Validation**: 98. Validate Binary Search Tree.
*   **General Tree Traversal**: 104. Maximum Depth of Binary Tree, 226. Invert Binary Tree.