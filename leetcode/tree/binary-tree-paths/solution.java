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
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    void solve(TreeNode root,String currentPath,List<String> result){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            currentPath += root.val;
            result.add(currentPath);
            return;
        }
        currentPath += root.val + "->";
        solve(root.left,currentPath,result);
        solve(root.right,currentPath,result);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        String currentPath = "";
        List<String> result = new ArrayList<>();
        solve(root,currentPath,result);
        return result;
    }
}