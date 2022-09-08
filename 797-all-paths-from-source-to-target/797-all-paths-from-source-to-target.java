class Solution {
    private void  dfs(int graph[][], int i, List<List<Integer>> res, List<Integer> list){
        list.add(i);
        if(i == graph.length -1){
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        for(int x : graph[i]){
            dfs(graph,x,res,list);
        }
        list.remove(list.size() -1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph,0,res,new ArrayList<>());
        return res;
    }
}