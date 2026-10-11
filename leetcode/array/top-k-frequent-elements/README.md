# 347. Top K Frequent Elements

## Problem

Find the `k` most frequent elements in a given integer array. The solution should be more efficient than O(N log N).

## Approach

The initial approach counts element frequencies using a hash map. It then converts these (number, frequency) pairs into a list. This list is sorted by frequency in descending order. Finally, the first `k` elements from the sorted list are collected as the result.

## Complexity

*   **Time Complexity**: O(N log N) in the worst case.
    *   Counting frequencies takes O(N).
    *   Sorting the list of unique elements takes O(U log U), where U is the number of unique elements. U can be up to N.
*   **Space Complexity**: O(U) in the worst case.
    *   The hash map stores U unique elements.
    *   The list of pairs also stores U elements.

This approach's O(N log N) time complexity does not meet the problem's follow-up requirement for a better-than O(N log N) solution.

## Review

The code for the described approach is clear and readable. It correctly uses a `HashMap` for frequency counting. A custom `Pair` class is used, which is functional. Lambda expressions are used for concise sorting. The logic for extracting the top `k` elements is straightforward.

## Improvements

The accepted solution does not meet the "better than O(N log N)" time complexity constraint.

The optimal approach uses **Bucket Sort** to achieve O(N) time complexity:
1.  Count frequencies of all numbers using a hash map (O(N) time).
2.  Create an array of lists (buckets), where the index represents a frequency. The maximum frequency is `N`.
3.  Populate these buckets: add each number to the list at its corresponding frequency index (O(U) time).
4.  Iterate through the buckets from highest frequency down to 1. Collect numbers until `k` elements are found (O(N) time).

Another improved approach uses a **Min-Heap (Priority Queue)** of size `k`. This results in O(N log k) time complexity, which is better than O(N log N) when `k < N`.

## Takeaways

*   **Frequency Counting**: `HashMap` is efficient for counting element occurrences (average O(1) operations).
*   **Bucket Sort**: For problems involving frequencies within a bounded range (like 0 to N), bucket sort can achieve O(N) time complexity. This avoids the O(N log N) lower bound of comparison sorts.
*   **"Top K" Problems**: When a simple sort is too slow, consider specialized techniques like min-heaps (O(N log k)) or bucket sort (O(N)) for optimal performance.

## Where it applies

This problem highlights key data structures and patterns:

*   **Hash Maps (Frequency Counting)**
    *   **When to use**: When you need to count occurrences, group items, or map keys to values quickly.
    *   **Similar LeetCode problems**: Two Sum, Group Anagrams, Longest Substring Without Repeating Characters, Contains Duplicate.

*   **Bucket Sort / Frequency Array**
    *   **When to use**: When sorting or grouping elements based on a property (like frequency) that has a limited and known range. It's powerful for "Top K" problems based on frequency.
    *   **Similar LeetCode problems**: Sort Colors, Maximum Gap, H-Index.

*   **Priority Queues (Heaps)**
    *   **When to use**: For "Top K" problems where you need to maintain the K largest/smallest elements efficiently, or for problems involving dynamic ordering.
    *   **Similar LeetCode problems**: Kth Largest Element in an Array, Merge K Sorted Lists, Find Median from Data Stream.