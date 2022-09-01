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
    int count = 0;
    private void countGoodNodes(TreeNode root, int max){
        if(root == null) return;
        if(root.val >=  max) count++;
        countGoodNodes(root.left,Math.max(max,root.val));
        countGoodNodes(root.right,Math.max(root.val,max));
    }
    public int goodNodes(TreeNode root) {
        countGoodNodes(root.left,root.val);
        countGoodNodes(root.right,root.val);
        return count + 1;
    }
}