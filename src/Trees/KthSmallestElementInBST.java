package Trees;

public class KthSmallestElementInBST {

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
        int res = 0;  // Variable to store the result (kth smallest element)
        int count = 0; // Counter to track the number of visited nodes

        public int kthSmallest(TreeNode root, int k) {
            inorder(root, k);
            return res;
        }

        // In-order traversal of the BST
        private void inorder(TreeNode root, int k) {
            if (root == null) return;  // Base case: If the node is null, return

            // Traverse the left subtree
            inorder(root.left, k);

            // Increment the count as we visit a node
            count++;

            // If the count matches k, we've found the kth smallest element
            if (count == k) {
                res = root.val;  // Store the kth smallest value
                return;  // Exit as we've found the result
            }

            // Traverse the right subtree
            inorder(root.right, k);
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInBST solution = new KthSmallestElementInBST();
        Solution sol = solution.new Solution();

        // Example Tree:
        //         3
        //        / \
        //       1   4
        //        \
        //         2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        // Example: Find the 1st smallest element (expected: 1)
        int k = 1;
        int result = sol.kthSmallest(root, k);
        System.out.println(k + "th smallest element: " + result); // Expected: 1

        // Example: Find the 3rd smallest element (expected: 3)
        k = 3;
        result = sol.kthSmallest(root, k);
        System.out.println(k + "th smallest element: " + result); // Expected: 3
    }
}