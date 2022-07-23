class Solution {
    class Pair{
        int i , j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int shortestBridge(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        outer:
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 1){
                        dfs(grid,i,j,queue,visited);    
                        break outer;
                    }
                }
            }
        return bfs(grid,queue,visited);
    }
    public void dfs(int grid[][],int i,int j,Queue<Pair> queue,boolean visited[][]){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)               return ;
        visited[i][j] = true;
        queue.add(new Pair(i,j));
        dfs(grid,i+1,j,queue,visited);
        dfs(grid,i,j+1,queue,visited);
        dfs(grid,i-1,j,queue,visited);
        dfs(grid,i,j-1,queue,visited);
    }
    public int bfs(int grid[][],Queue<Pair> queue, boolean visited[][]){
        int ans = 0;
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0)
                {
                Pair p = queue.remove();
                for(int d[] : dir){
                    int i = p.i + d[0];
                    int j = p.j + d[1];
                    if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length &&!visited[i][j]){
                        // System.out.println
                        if(grid[i][j] == 1) return ans;
                        queue.add(new Pair(i , j));
                        visited[i][j] = true;
                    }
                }}
            ans++;
            // System.out.println(ans + " " + queue.size());
        }
        return ans;
    }
}