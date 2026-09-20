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
    public static void markParents(TreeNode root,Map<TreeNode,TreeNode> parentMarker){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                parentMarker.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right!=null){
                parentMarker.put(node.right,node);
                queue.add(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMarker = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        markParents(root,parentMarker);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target,true);
        int currentLevel = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(currentLevel==k){
                break;
            }
            currentLevel++;
            while(size>0){
                TreeNode node = queue.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    queue.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    queue.add(node.right);
                    visited.put(node.right,true);
                }
                if(parentMarker.get(node)!=null && visited.get(parentMarker.get(node))==null){
                    queue.add(parentMarker.get(node));
                    visited.put(parentMarker.get(node),true);
                }
                size--;
            }
        }
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}