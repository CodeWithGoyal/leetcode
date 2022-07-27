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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root,list);
        for(int i = 1; i < list.size(); i++){
            list.get(i-1).right = list.get(i);
            list.get(i-1).left = null;
        }
    }
    private void preorder(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        list.add(root);
        preorder(root.left,list);
        preorder(root.right,list);
    }
}