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
    class Pair{
        TreeNode node;
        int dist;
        Pair(int d,TreeNode node){
            this.node = node;
            this.dist = d;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(0,root));
        while(list.isEmpty() == false){
            Collections.sort(list,new Comparator<>(){
                public int compare(Pair p1, Pair p2){
                    return p1.node.val - p2.node.val;
                }
            });
            int size = list.size();
            for(int i = 0; i < size; i++){
                Pair p = list.remove(0);
                if(map.containsKey(p.dist) == false) map.put(p.dist,new ArrayList<>());
                map.get(p.dist).add(p.node.val);
                if(p.node.left != null) list.add(new Pair(p.dist - 1, p.node.left));
                if(p.node.right != null) list.add(new Pair(p.dist + 1, p.node.right));
            }
            
        }
        for(Map.Entry<Integer, List<Integer>> e : map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}