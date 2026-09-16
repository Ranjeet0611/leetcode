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
    int minDiff = Integer.MAX_VALUE;
    Integer prevVal = null; // Stores the value of the previously visited node in in-order traversal

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left); // Traverse left subtree

        // Process current node
        if (prevVal != null) {
            // In an in-order traversal of a BST, current node's value is always >= prevVal
            minDiff = Math.min(minDiff, node.val - prevVal);
        }
        prevVal = node.val; // Update prevVal to current node's value

        inorderTraversal(node.right); // Traverse right subtree
    }
}