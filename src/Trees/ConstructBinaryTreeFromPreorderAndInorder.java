package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        private int preorderIndex = 0;
        private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // Create a map for inorder values to their indices to optimize search
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            return buildTreeHelper(preorder, 0, preorder.length - 1);
        }

        private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
            // Base case: if the subtree has no elements
            if (left > right) return null;

            // Get the root value from preorder and create a TreeNode
            int rootVal = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootVal);

            // Find the index of root in inorder array
            int rootIndex = inorderIndexMap.get(rootVal);

            // Recursively build the left and right subtrees
            root.left = buildTreeHelper(preorder, left, rootIndex - 1);  // Left subtree
            root.right = buildTreeHelper(preorder, rootIndex + 1, right); // Right subtree

            return root;
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorder solution = new ConstructBinaryTreeFromPreorderAndInorder();
        Solution sol = solution.new Solution();

        // Example:
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = sol.buildTree(preorder, inorder);

        // The tree structure can be printed or verified using additional methods
    }
}