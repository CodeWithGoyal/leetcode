class Solution {
    class Pair{
        int i, j,dist;
        Pair(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int maxDistance(int[][] grid) {
        int water = 0, land = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    queue.add(new Pair(i,j,0));
                    grid[i][j] = -2;
                    land++;
                }
                else{
                    water++;
                }
            }
        }
        int n = grid.length;
        if(land == n*n || water == n*n){
            return -1;
            
        }
        int directions[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        int res = -1;
        while(queue.isEmpty() == false){
            Pair temp = queue.remove();
            for(int i = 0; i < 4; i++){
                int x = temp.i + directions[i][0];
                int y = temp.j + directions[i][1];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0){
                    queue.add(new Pair(x,y,temp.dist + 1));
                    grid[x][y] = -2;
                    res = Math.max(res,temp.dist + 1);
                }
            }
        }
        return res;
    }
}