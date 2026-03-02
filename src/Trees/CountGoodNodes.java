package Trees;

public class CountGoodNodes {

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
        public int goodNodes(TreeNode root) {
            return dfs(root, Integer.MIN_VALUE);
        }

        // DFS function to count good nodes
        private int dfs(TreeNode root, int maxVal){
            if(root == null) return 0;

            int count = 0;
            if(root.val >= maxVal){
                count = 1;  // This node is good
                maxVal = root.val;  // Update maxVal for next nodes
            }

            // Recursively count good nodes in the left and right subtrees
            count += dfs(root.left, maxVal);
            count += dfs(root.right, maxVal);

            return count;
        }
    }

    public static void main(String[] args) {
        CountGoodNodes solution = new CountGoodNodes();
        Solution sol = solution.new Solution();

        // Example Tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        // Calculate the number of good nodes
        int result = sol.goodNodes(root);
        System.out.println("Number of good nodes: " + result);  // Expected: 4
    }
}
