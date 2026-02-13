package LinkedList;

public class FlattenBinaryTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {

        public void flatten(TreeNode root) {
            flattenTree(root);
        }

        public TreeNode flattenTree(TreeNode node) {
            if (node == null) return null;

            if (node.left == null && node.right == null) {
                return node;
            }

            TreeNode leftTail = flattenTree(node.left);
            TreeNode rightTail = flattenTree(node.right);

            if (leftTail != null) {
                leftTail.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            return rightTail == null ? leftTail : rightTail;
        }
    }

    // Print flattened tree (right-skewed list)
    public static void printRightList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   5
             / \   \
            3   4   6
        */

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(5,
                        null,
                        new TreeNode(6)));

        Solution sol = new Solution();

        System.out.println("Flattening tree...");
        sol.flatten(root);

        System.out.println("Flattened list:");
        printRightList(root);
    }
}

