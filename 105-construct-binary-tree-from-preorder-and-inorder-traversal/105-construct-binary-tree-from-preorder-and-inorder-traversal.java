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
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder,int [] inorder, int start, int end){
        if(start > end){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int i;
        for( i = 0; i <= end; i++){
            if(inorder[i] == node.val){
                break;
            }
        }
        node.left = buildTree(preorder, inorder, start,i-1);
        node.right = buildTree(preorder, inorder, i+1,end);
        return node;
    }
    
}