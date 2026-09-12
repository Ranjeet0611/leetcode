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
    TreeNode solve(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return null;
        }
        if(root1==null && root2!=null){
            return root2;
        }
        if(root1!=null && root2==null){
            return root1;
        }
        int value = root1.val + root2.val;
        TreeNode root = new TreeNode(value);
        root.left = solve(root1.left,root2.left);
        root.right = solve(root1.right,root2.right);
        return root;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return solve(root1,root2);
    }
}