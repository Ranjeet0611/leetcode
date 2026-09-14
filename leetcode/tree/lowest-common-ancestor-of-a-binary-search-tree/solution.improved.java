class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Iterate until we find the LCA
        while (root != null) {
            // If both p and q are smaller than the current root, LCA must be in the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are larger than the current root, LCA must be in the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // Otherwise, the current root is the LCA. This covers cases where:
            // 1. p is in one subtree and q is in the other.
            // 2. root itself is p or q (and the other node is in its subtree).
            else {
                return root;
            }
        }
        return null; // Should not be reached as p and q are guaranteed to exist in the BST.
    }
}