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
    void solve(TreeNode root,Stack<TreeNode> st){
        if(root==null){
            return;
        }
        st.push(root);
        solve(root.left,st);
        solve(root.right,st);
    }
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        solve(root,st);
        TreeNode node = null;
        while(st.empty()==false){
            TreeNode current = st.pop();
            current.left = null;
            current.right = node;
            node = current;
        }
    }
}