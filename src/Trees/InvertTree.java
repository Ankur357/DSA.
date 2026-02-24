package Trees;

public class InvertTree {

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

    // Solution class to invert the binary tree
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            // Swap the left and right subtrees
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            // Recursively invert the left and right subtrees
            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }

    // Main function to test the Solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example tree:
        //      4
        //    /   \
        //   2     7
        //  / \   / \
        // 1   3 6   9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Inverting the tree
        TreeNode invertedRoot = solution.invertTree(root);

        // Printing the root value of the inverted tree (or you can implement a tree traversal to verify)
        System.out.println("Inverted Tree Root: " + invertedRoot.val); // Should print 4
    }
}