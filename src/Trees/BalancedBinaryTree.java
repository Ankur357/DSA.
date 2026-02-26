package Trees;

public class BalancedBinaryTree {

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

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        if (root == null) return 0;

        // Recursively calculate the height of left and right subtrees
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1; // If left subtree is unbalanced, return -1

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; // If right subtree is unbalanced, return -1

        // Check if current node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Example usage of the BalancedBinaryTree class
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);

        BalancedBinaryTree solution = new BalancedBinaryTree();
        System.out.println("Is the tree balanced? " + solution.isBalanced(root1));  // Should return true

        // Example of an unbalanced tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        System.out.println("Is the tree balanced? " + solution.isBalanced(root2));  // Should return false
    }
}