/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode sm = p.val > q.val?q:p;
        TreeNode lg = p.val < q.val?q:p;
        if(root == p || root == q){
            return root;
        }
        else if(root.val < lg.val && root.val > sm.val){
            return root;
        }
        else{
            if(root.val > lg.val){
                return lowestCommonAncestor(root.left,p,q);
            } else {
                return lowestCommonAncestor(root.right,p,q);
            }
        }
    }
}