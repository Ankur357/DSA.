package Trees;

public class BinaryTreeMaximumPathSum {

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

        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        private int maxGain(TreeNode node) {
            if (node == null) return 0;

            // Only take positive contributions
            int leftGain = Math.max(0, maxGain(node.left));
            int rightGain = Math.max(0, maxGain(node.right));

            // Price of the path passing through this node
            int currentPathSum = node.val + leftGain + rightGain;

            // Update global maximum
            maxSum = Math.max(maxSum, currentPathSum);

            // Return max gain to parent (choose one side)
            return node.val + Math.max(leftGain, rightGain);
        }
    }

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum solution =
                new BinaryTreeMaximumPathSum();

        Solution sol = solution.new Solution();

        // Example:
        //       -10
        //       /  \
        //      9   20
        //         /  \
        //        15   7

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20,
                new TreeNode(15),
                new TreeNode(7));

        System.out.println(sol.maxPathSum(root)); // Output: 42
    }
}