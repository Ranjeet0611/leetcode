## Problem
Convert a sorted array into a height-balanced Binary Search Tree (BST).

## Approach
This solution uses a recursive, divide-and-conquer strategy.
It picks the middle element of the current array segment as the root.
This choice splits the remaining elements into two roughly equal halves.
The left half recursively builds the left subtree.
The right half recursively builds the right subtree.
This process ensures the tree remains height-balanced.
Recursion stops when an empty array segment is encountered.

## Complexity
*   **Time:** O(N), where N is the number of elements. Each element is processed once to create a node.
*   **Space:** O(N) for storing the tree nodes. O(log N) for the recursion stack, as the tree is height-balanced.

## Review
The core logic correctly builds a height-balanced BST using recursion.
Choosing the middle element as the root maintains BST properties and ensures balance.
A minor structural issue exists: a `while` loop inside the `solve` method is redundant. It functions as an `if` condition.

## Improvements
The current algorithm is already optimal in terms of time and space complexity.
It achieves O(N) time and O(N) space.
A minor code style improvement would be to remove the redundant `while (start <= end)` loop.
This makes the code cleaner without changing its correctness or performance.

## Takeaways
*   **Divide and Conquer:** Break down a problem into smaller, similar subproblems.
*   **Recursion:** A natural way to implement divide and conquer for tree structures.
*   **BST Properties:** Leverage sorted input to maintain `left < root < right` order.
*   **Height-Balanced Trees:** Choosing the middle element as root minimizes tree height to O(log N).
*   **Array to Tree Conversion:** A fundamental pattern for transforming linear data into hierarchical structures.

## Where it applies
This problem demonstrates fundamental concepts in data structures and algorithms.

**Data Structures:**
*   **Binary Search Trees (BSTs):** Core for efficient searching, insertion, and deletion of ordered data. This problem focuses on building a height-balanced BST.

**Algorithms/Patterns:**
*   **Divide and Conquer:** Breaking a problem into smaller, independent subproblems.
*   **Recursion:** Implementing divide and conquer, especially for tree structures.
*   **Binary Search:** The method of finding the `mid` element and splitting the array is analogous to binary search.

**When to reach for them:**
*   When you need to organize sorted linear data into a structure that allows for fast lookups and updates.
*   When building balanced trees is crucial to guarantee logarithmic time complexity for operations.
*   When converting one data representation (array) into another (tree) for specific advantages.

**Similar LeetCode problems:**
*   Construct Binary Tree from Preorder and Inorder Traversal (105)
*   Validate Binary Search Tree (98)
*   Balanced Binary Tree (110)
*   Kth Smallest Element in a BST (230)