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
    int solve(TreeNode root,int low,int high){
        if(root==null){
            return 0;
        }
        int result = 0;
        if(root.val>=low && root.val<=high){
            result += root.val;
        }
        return result + solve(root.right,low,high) + solve(root.left,low,high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        result = solve(root,low,high);
        return result;
    }
}