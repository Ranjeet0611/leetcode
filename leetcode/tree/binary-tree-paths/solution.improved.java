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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // Use StringBuilder for efficient path construction
        StringBuilder currentPath = new StringBuilder();
        solve(root, currentPath, result);
        return result;
    }

    private void solve(TreeNode node, StringBuilder currentPath, List<String> result) {
        // Store the length before appending to allow backtracking
        int lenBeforeAppend = currentPath.length();
        
        // Append current node's value
        currentPath.append(node.val);

        // If it's a leaf node, add the path to result
        if (node.left == null && node.right == null) {
            result.add(currentPath.toString());
        } else {
            // Not a leaf, continue path by appending '->'
            currentPath.append("->");
            if (node.left != null) {
                solve(node.left, currentPath, result);
            }
            if (node.right != null) {
                solve(node.right, currentPath, result);
            }
        }
        
        // Backtrack: remove the current node's value and '->' (if added)
        // This restores the StringBuilder to its state before processing the current node
        currentPath.setLength(lenBeforeAppend);
    }
}