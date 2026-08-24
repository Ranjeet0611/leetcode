/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        // If current node's value is within the range, add it to sum
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // If current node's value is greater than low,
        // it's possible that its left child (and its subtree)
        // could contain values within the range [low, high].
        // So, traverse left.
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // If current node's value is less than high,
        // it's possible that its right child (and its subtree)
        // could contain values within the range [low, high].
        // So, traverse right.
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}