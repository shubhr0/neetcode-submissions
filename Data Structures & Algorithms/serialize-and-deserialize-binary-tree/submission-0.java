/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    public void serial(TreeNode root,StringBuilder data){
        if(root==null){
            data.append("N#");
            return;
        }
        data.append(root.val).append('#');
        serial(root.left,data);
        serial(root.right,data);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        serial(root, data);
        return data.toString();
    }

    private TreeNode buildTree(String[] nodes, int[] index) {
        String value = nodes[index[0]++];

        if (value.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = buildTree(nodes, index);
        root.right = buildTree(nodes, index);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("#");
        int[] index = {0};
        return buildTree(nodes, index);
    }
}
