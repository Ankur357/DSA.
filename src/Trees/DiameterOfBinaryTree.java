package Trees;

public class DiameterOfBinaryTree {

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
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return maxDiameter;
        }

        // DFS function to calculate the diameter
        private int dfs(TreeNode node) {
            if (node == null) return 0;

            // Get the height of the left and right subtrees
            int left = dfs(node.left);
            int right = dfs(node.right);

            // Calculate the diameter at the current node
            maxDiameter = Math.max(maxDiameter, left + right);

            // Return the height of the current node's subtree
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        Solution sol = solution.new Solution();

        // Example Tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Calculate the diameter of the binary tree
        int result = sol.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result);  // Expected: 3
    }
}