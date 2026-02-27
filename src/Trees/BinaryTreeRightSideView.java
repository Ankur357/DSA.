package Trees;

import java.util.*;

public class BinaryTreeRightSideView {

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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();

                    // Add the last node of the level to the list (rightmost node)
                    if (i == count - 1) {
                        list.add(node.val);
                    }

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        // Example usage of the BinaryTreeRightSideView class
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        Solution solution = new BinaryTreeRightSideView().new Solution();
        List<Integer> result = solution.rightSideView(root1);
        System.out.println("Right Side View: " + result); // Expected: [1, 3, 4]

        // Example with another tree
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);
        root2.right.right = new TreeNode(5);
        root2.right.left.left = new TreeNode(4);

        result = solution.rightSideView(root2);
        System.out.println("Right Side View: " + result); // Expected: [1, 3, 5, 4]
    }
}