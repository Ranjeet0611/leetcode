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
    int maxDiameter = 0; // Stores the maximum diameter found so far

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0; // Reset for each call to ensure correctness if Solution object is reused
        dfs(root);
        return maxDiameter;
    }

    /**
     * Helper function to perform a DFS traversal.
     * It calculates the height of the subtree rooted at 'node'
     * and updates the global maxDiameter based on paths passing through 'node'.
     * @param node The current node being processed.
     * @return The height of the subtree rooted at 'node'.
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the height of the left and right subtrees
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // The diameter passing through the current node is leftHeight + rightHeight.
        // Update the global maximum diameter if this path is longer.
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current subtree to its parent.
        // Height is 1 (for the current node) + the maximum height of its children.
        return 1 + Math.max(leftHeight, rightHeight);
    }
}