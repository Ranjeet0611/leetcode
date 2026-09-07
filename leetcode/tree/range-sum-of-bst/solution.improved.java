class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int currentSum = 0;

        // If the current node's value is within the range, add it to the sum.
        if (root.val >= low && root.val <= high) {
            currentSum += root.val;
        }

        // If root.val is greater than low, it's possible that values in the left subtree
        // are within the range [low, high]. So, recursively check the left subtree.
        // We only need to go left if root.val is not already too small to be the 'low' boundary.
        if (root.val > low) {
            currentSum += rangeSumBST(root.left, low, high);
        }

        // If root.val is less than high, it's possible that values in the right subtree
        // are within the range [low, high]. So, recursively check the right subtree.
        // We only need to go right if root.val is not already too large to be the 'high' boundary.
        if (root.val < high) {
            currentSum += rangeSumBST(root.right, low, high);
        }

        return currentSum;
    }
}