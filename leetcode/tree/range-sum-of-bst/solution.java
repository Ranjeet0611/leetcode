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
        int currentSum = 0;
        if(root.val>=low && root.val<=high){
            currentSum += root.val;
        }
        if(root.val>low){
            currentSum +=solve(root.left,low,high);
        }
        if(root.val<high){
            currentSum +=solve(root.right,low,high);
        }
        return currentSum;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return solve(root,low,high);
    }
}