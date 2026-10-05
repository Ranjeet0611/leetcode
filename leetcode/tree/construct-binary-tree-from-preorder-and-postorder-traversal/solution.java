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
    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;
        if(node.val!=postorder[postIndex]){
            node.left = constructFromPrePost(preorder,postorder);
        }
        if(node.val!=postorder[postIndex]){
            node.right = constructFromPrePost(preorder,postorder);
        }
        postIndex++;
        return node;
    }
}