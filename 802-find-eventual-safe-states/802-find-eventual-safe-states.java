class Solution {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int visited[], List<Integer> res, int i){
        if(visited[i] == -1) return false;
        if(visited[i ] == 1) return true;
        if(visited[i] == -2) return false;
        if(adj.get(i).size() == 0){
            visited[i] = 1;
            // res.add(i);
            return true;
        }
        visited[i] = -2;
        boolean re = true;
        for(int x : adj.get(i)){
            re = re & dfs(adj,visited,res,x);
        }
        if(re) { visited[i] = 1;}
        else visited[i] = -1;
        
        return visited[i] == 1;
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
            for(int x : graph[i])
                adj.get(i).add(x);
        }
       int visited[] = new int[graph.length];
        for(int i = 0;i < graph.length; i++){
            // if(visited[i] == 0){
            if(dfs(adj,visited,res,i)){
                res.add(i);
            }
            // }
        }
        // Collections.sort(res);
        return res;
    }
}