class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        // Base case: null node or result already found (early termination)
        if (node == null || result != -1) {
            return;
        }

        // Traverse left subtree
        inorder(node.left, k);

        // If result was found in the left subtree, stop further processing
        if (result != -1) {
            return;
        }

        // Visit current node
        count++;
        if (count == k) {
            result = node.val; // Found the k-th smallest element
            return; // Stop further traversal
        }

        // Traverse right subtree
        inorder(node.right, k);
    }
}