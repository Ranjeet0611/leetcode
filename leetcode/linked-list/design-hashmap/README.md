# 706. Design HashMap

## Problem
Implement a HashMap without using any built-in hash table libraries. It should support `put`, `get`, and `remove` operations.

## Approach
The accepted solution uses an array of singly linked lists, a technique called **chaining**, to handle hash collisions.
A simple modulo operation (`key % capacity`) serves as the hash function.
- `put(key, value)`: Finds the bucket. If the key exists, its value is updated. Otherwise, a new node is added to the linked list.
- `get(key)`: Finds the bucket. Traverses the linked list to find the key and returns its value, or -1 if not found.
- `remove(key)`: Finds the bucket. Traverses the linked list to locate and remove the node.

## Complexity
### Time
- **`put`**: Average O(1), Worst O(L) where L is the linked list length. The current implementation has a logical error, potentially traversing the list twice for new keys. Practically O(1) due to very low collision rates.
- **`get`**: Average O(1), Worst O(L). Practically O(1) due to low collision rates.
- **`remove`**: Average O(1), Worst O(L). The current implementation has a logical error in pointer handling and early exit. Practically O(1) due to low collision rates.

### Space
- O(capacity + N), where `capacity` is the array size and `N` is the number of stored key-value pairs.
- The solution uses a `capacity` of `10,000,000`. This is excessively large for the problem's constraints (max 10,000 keys). It results in about 80MB for the array alone, plus memory for linked list nodes.

## Review
The accepted solution is functional but has several areas for improvement:
- **`CustomLinkedList`**: The `next` field is public, making `getNext()` redundant.
- **Constructor**: The explicit loop to initialize the `bucket` array with `null` is unnecessary in Java.
- **`put` Method**: Inefficiently traverses the linked list twice if a new key needs to be added.
- **`remove` Method**: Contains a logical bug in pointer updates after removing a node and doesn't return immediately.
- **Capacity**: The chosen `10,000,000` capacity is far too large, leading to significant memory waste. While it ensures O(1) practical performance, it's not memory-efficient.

## Improvements
The accepted solution is not optimal. Here are key improvements:
1.  **Optimize Space**: Reduce the `CustomHashMap` capacity to a more reasonable value, like `100,000` or `1,000,000`. This drastically cuts memory usage without significantly impacting average-case time.
2.  **Fix `put` Logic**: If a key is not found, prepend the new node to the head of the linked list. This is an O(1) operation and avoids a second traversal.
3.  **Fix `remove` Logic**: Correctly update `prev.next` pointers when removing a node. Ensure the method returns immediately after a node is removed.
4.  **Minor Cleanups**: Remove the redundant `null` initialization loop in the `CustomHashMap` constructor.

These changes maintain the core chaining approach while fixing bugs and improving space efficiency.

## Takeaways
-   **Hash Map Chaining**: A fundamental way to implement hash maps, resolving collisions with linked lists.
-   **Capacity Selection**: Choosing the right hash table capacity is crucial. It balances memory usage against collision rates and performance.
-   **Linked List Manipulation**: Correctly handling pointers for insertion and deletion in linked lists is vital for bug-free code.
-   **Trade-offs**: Implementing data structures from scratch highlights the trade-offs between memory, average-case, and worst-case performance.

## Where it applies
This problem demonstrates core concepts of hash tables and linked lists, fundamental data structures with widespread applications.

**Data Structures & Patterns Used:**
*   **Hash Tables (HashMaps)**: For efficient key-value storage and retrieval.
*   **Chaining**: A collision resolution strategy using linked lists in each bucket.
*   **Singly Linked Lists**: Used to store multiple elements that hash to the same bucket.
*   **Modulo Hashing**: A simple hash function to map keys to array indices.

**When to reach for them:**
*   When you need fast average-case O(1) lookups, insertions, and deletions of key-value pairs.
*   For implementing caches, symbol tables, or frequency counters.
*   As a building block for more complex data structures.

**Other LeetCode Problems They Typically Unlock:**
*   **1. Two Sum**: Find pairs that sum to a target.
*   **49. Group Anagrams**: Group strings that are anagrams of each other.
*   **146. LRU Cache**: Design a Least Recently Used cache.
*   **705. Design HashSet**: Implement a HashSet from scratch (similar to HashMap but without values).