package Trees;

public class ValidateBinarySearchTree {

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
        private Integer prev;

        public boolean isValidBST(TreeNode root) {
            prev = null;
            return inOrder(root);
        }

        // Helper function to perform in-order traversal
        private boolean inOrder(TreeNode root){
            if (root == null) return true;

            // Traverse the left subtree
            if (!inOrder(root.left)) return false;

            // Check if the current node's value is greater than the previous node's value
            if (prev != null && root.val <= prev) return false;

            // Update previous node's value
            prev = root.val;

            // Traverse the right subtree
            return inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        Solution sol = solution.new Solution();

        // Example Tree:
        //         2
        //        / \
        //       1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Check if the binary tree is a valid BST
        boolean result = sol.isValidBST(root);
        System.out.println("Is the binary tree a valid BST? " + result);  // Expected: true
    }
}