public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If subRoot is null, it's always a subtree (an empty tree is a subtree of any tree).
        if (subRoot == null) {
            return true;
        }
        // If root is null (and subRoot is not null), subRoot cannot be a subtree.
        if (root == null) {
            return false;
        }

        // Check if the tree rooted at 'root' is identical to 'subRoot'
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Otherwise, recursively check if subRoot is a subtree of root's left or right child
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Helper function to check if two trees are structurally identical and have the same node values.
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // One is null and the other is not, they are not identical
        if (p == null || q == null) {
            return false;
        }
        // Values are different, they are not identical
        if (p.val != q.val) {
            return false;
        }
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}