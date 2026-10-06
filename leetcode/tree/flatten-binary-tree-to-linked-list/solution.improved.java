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
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                
                // Connect the rightmost node of the left subtree to the current right subtree
                // This effectively appends the original right subtree after the flattened left subtree
                predecessor.right = current.right;
                
                // Move the entire left subtree to become the new right subtree of current
                current.right = current.left;
                
                // Clear the left pointer as per problem requirements
                current.left = null;
            }
            // Move to the next node in the flattened list (which is now current.right)
            current = current.right;
        }
    }
}