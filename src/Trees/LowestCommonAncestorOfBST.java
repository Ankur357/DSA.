package Trees;

public class LowestCommonAncestorOfBST {

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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // If both p and q are greater than root, LCA must be in the right subtree
            if (root.val < p.val && root.val < q.val)
                return lowestCommonAncestor(root.right, p, q);

                // If both p and q are less than root, LCA must be in the left subtree
            else if (root.val > p.val && root.val > q.val)
                return lowestCommonAncestor(root.left, p, q);

                // If root is between p and q, root is the LCA
            else return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBST solution = new LowestCommonAncestorOfBST();
        Solution sol = solution.new Solution();

        // Example Tree:
        //         6
        //        / \
        //       2   8
        //      / \ / \
        //     0  4 7  9
        //        / \
        //       3   5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Example: Find LCA of 2 and 8
        TreeNode p = root.left;  // Node 2
        TreeNode q = root.right; // Node 8

        // Find the LCA
        TreeNode result = sol.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of 2 and 8: " + result.val);  // Expected: 6

        // Example: Find LCA of 2 and 4
        p = root.left;  // Node 2
        q = root.left.right;  // Node 4
        result = sol.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of 2 and 4: " + result.val);  // Expected: 2
    }
}