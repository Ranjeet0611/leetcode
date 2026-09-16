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
    void solve(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        solve(root.left,result);
        result.add(root.val);
        solve(root.right,result);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        solve(root,result);
        for(int i=0;i<result.size()-1;i++){
            ans = Math.min(ans,Math.abs(result.get(i)-result.get(i+1)));
        }
        return ans;
    }
}