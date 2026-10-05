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
    int result = 0;
    void solve(TreeNode root,long targetSum){
        if(root==null){
            return;
        }
        if(targetSum==root.val){
            result++;
        }
        solve(root.left,targetSum-root.val);
        solve(root.right,targetSum-root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        solve(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return result;
    }
}