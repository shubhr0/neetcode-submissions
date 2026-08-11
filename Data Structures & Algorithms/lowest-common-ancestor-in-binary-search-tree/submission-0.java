class Solution {

    public TreeNode lowest(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }


        if (p.val < root.val && q.val < root.val) {
            return lowest(root.left, p, q);
        }


        if (p.val > root.val && q.val > root.val) {
            return lowest(root.right, p, q);
        }


        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowest(root, p, q);
    }
}