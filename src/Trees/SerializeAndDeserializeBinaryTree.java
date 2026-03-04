package Trees;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
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

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        private void serializeHelper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null,");
                return;
            }

            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] values = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(values));
            return deserializeHelper(queue);
        }

        private TreeNode deserializeHelper(Queue<String> queue) {
            String value = queue.poll();

            if (value.equals("null")) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(value));
            node.left = deserializeHelper(queue);
            node.right = deserializeHelper(queue);

            return node;
        }
    }

    public static void main(String[] args) {

        SerializeAndDeserializeBinaryTree solution =
                new SerializeAndDeserializeBinaryTree();

        Codec codec = solution.new Codec();

        // Build sample tree:
        //        1
        //       / \
        //      2   3
        //         / \
        //        4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3,
                new TreeNode(4),
                new TreeNode(5));

        // Serialize
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize
        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized root value: " + deserializedRoot.val);
    }
}