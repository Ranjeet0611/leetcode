class Solution {
    int count = 0;
    Map<Long, Integer> prefixSumCounts;

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        prefixSumCounts = new HashMap<>();
        // Initialize with 0 sum having one occurrence to handle paths starting from the root
        prefixSumCounts.put(0L, 1);
        
        dfs(root, 0L, targetSum);
        return count;
    }

    private void dfs(TreeNode node, long currentSum, int targetSum) {
        if (node == null) {
            return;
        }

        // Update current sum
        currentSum += node.val;

        // Check if there's a path ending at the current node that sums to targetSum
        // This means we need to find an ancestor's prefix sum such that:
        // currentSum - ancestor_prefix_sum = targetSum
        // ancestor_prefix_sum = currentSum - targetSum
        count += prefixSumCounts.getOrDefault(currentSum - targetSum, 0);

        // Add the current sum to the map
        prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);

        // Recurse on children
        dfs(node.left, currentSum, targetSum);
        dfs(node.right, currentSum, targetSum);

        // Backtrack: Remove the current sum from the map
        // This is essential to ensure paths only go downwards and don't use nodes from sibling subtrees.
        prefixSumCounts.put(currentSum, prefixSumCounts.get(currentSum) - 1);
    }
}