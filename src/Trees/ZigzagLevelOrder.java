package Trees;

import java.util.*;

public class ZigzagLevelOrder {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int count = queue.size();
            Deque<Integer> level = new LinkedList<>();

            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            list.add(new ArrayList<>(level));
            leftToRight = !leftToRight;  // Toggle the direction
        }
        return list;
    }

    public static void main(String[] args) {
        // Example usage of the ZigzagLevelOrder class
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        ZigzagLevelOrder solution = new ZigzagLevelOrder();
        List<List<Integer>> result = solution.zigzagLevelOrder(root1);
        System.out.println("Zigzag Level Order: " + result); // Expected: [[3], [20, 9], [15, 7]]

        // Example with another tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        result = solution.zigzagLevelOrder(root2);
        System.out.println("Zigzag Level Order: " + result); // Expected: [[1], [3, 2], [4, 5, 6, 7]]
    }
}