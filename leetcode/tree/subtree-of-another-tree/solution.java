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
    boolean check(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }
        if(root.val==subRoot.val){
            return check(root.left,subRoot.left) && check(root.right,subRoot.right);
        }
        return check(root.left,subRoot) || check(root.right,subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return check(root,subRoot);
    }
}