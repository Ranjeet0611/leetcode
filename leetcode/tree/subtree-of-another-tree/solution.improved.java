```java
import java.util.ArrayList;
import java.util.List;

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
    // KMP algorithm for string matching
    private boolean kmpSearch(List<Integer> text, List<Integer> pattern) {
        if (pattern.isEmpty()) return true;
        if (text.isEmpty()) return false;

        int n = text.size();
        int m = pattern.size();

        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < n) {
            if (pattern.get(j).equals(text.get(i))) {
                i++;
                j++;
            }
            if (j == m) {
                return true; // Pattern found
            } else if (i < n && !pattern.get(j).equals(text.get(i))) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private int[] computeLPSArray(List<Integer> pattern) {
        int m = pattern.size();
        int[] lps = new int[m];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (pattern.get(i).equals(pattern.get(length))) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Serialize tree into a list of integers (pre-order traversal)
    // Use a unique marker for null nodes (e.g., Integer.MIN_VALUE)
    // Use another unique marker for boundary (e.g., Integer.MAX_VALUE) to distinguish nodes
    private void serialize(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(Integer.MIN_VALUE); // Marker for null
            return;
        }
        list.add(node.val);
        list.add(Integer.MAX_VALUE); // Delimiter for node value
        serialize(node.left, list);
        serialize(node.right, list);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true; // An empty tree is a subtree of any tree
        if (root == null) return false; // A non-empty subRoot cannot be a subtree of an empty root

        List<Integer> rootSerialization = new ArrayList<>();
        serialize(root, rootSerialization);

        List<Integer> subRootSerialization = new ArrayList<>();
        serialize(subRoot, subRootSerialization);

        // Use KMP to check if subRootSerialization is a substring of rootSerialization
        return kmpSearch(rootSerialization, subRootSerialization);
    }
}
```