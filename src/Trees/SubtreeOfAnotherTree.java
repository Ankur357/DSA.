package Trees;

public class SubtreeOfAnotherTree {

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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) return false;

            // Check if the current node is the same as subRoot
            if (isSameTree(root, subRoot)) return true;

            // Recursively check the left and right subtrees of root
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        // Helper method to check if two trees are identical
        private boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) return true;

            // If one is null and the other isn't, they aren't the same
            if (s == null || t == null || s.val != t.val) return false;

            // Recursively check left and right children
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        Solution sol = solution.new Solution();

        // Example tree 1 (root)
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(0);

        // Example tree 2 (subRoot)
        TreeNode subRoot1 = new TreeNode(4);
        subRoot1.left = new TreeNode(1);
        subRoot1.right = new TreeNode(2);

        // Check if subRoot1 is a subtree of root1
        boolean result = sol.isSubtree(root1, subRoot1);
        System.out.println("Is subRoot1 a subtree of root1? " + result); // Expected: true

        // Another test case where subRoot is not a subtree of root
        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(3);

        result = sol.isSubtree(root1, subRoot2);
        System.out.println("Is subRoot2 a subtree of root1? " + result); // Expected: false
    }
}