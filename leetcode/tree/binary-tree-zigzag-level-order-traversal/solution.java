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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    level.addLast(node.val);
                }
                else{
                    level.addFirst(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(new LinkedList<>(level));
            leftToRight = !leftToRight;
        }
        return result;
    }
}