/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode solve(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left = solve(root.left,p,q);
        TreeNode right = solve(root.right,p,q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        else{
            return root;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
}