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

class Solution {
    int count=0;
    public void dfs(TreeNode root,int maxsofar){
        if(root==null){
            return;
        }
        if(root.val>=maxsofar){
            count++;
        }
        maxsofar = Math.max(maxsofar, root.val);
        dfs(root.left,maxsofar);
        dfs(root.right,maxsofar);
    }
    public int goodNodes(TreeNode root) {
        int maxsofar=root.val;
        dfs(root,maxsofar);
        return count;
    }
}
