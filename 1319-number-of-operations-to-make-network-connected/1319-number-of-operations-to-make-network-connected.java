class Solution {
    private void dfs(List<List<Integer>> adj,int i,boolean visited[]){
        if(visited[i]) return;
        visited[i] = true;
        for(int x : adj.get(i)) dfs(adj,x,visited);
    }
    public int makeConnected(int n, int[][] connections) {
        if(n > connections.length + 1) return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int a[] : connections){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count -1;
    }
}