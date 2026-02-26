package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

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
        List<List<Integer>> res = new ArrayList<>();

        private void order(TreeNode root, int level) {
            if (root == null) return;

            // If there's no list for this level, create one
            if (res.size() == level) {
                res.add(new ArrayList<>());
            }

            // Add the current node's value to the corresponding level
            res.get(level).add(root.val);

            // Recursively process left and right children, increasing the level
            if (root.left != null) order(root.left, level + 1);
            if (root.right != null) order(root.right, level + 1);
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return res;
            order(root, 0);  // Start DFS traversal from level 0
            return res;
        }
    }

    public static void main(String[] args) {
        // Example usage of the BinaryTreeLevelOrderTraversal class
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        // Printing the level order traversal
        System.out.println("Level Order Traversal: " + result);
    }
}
