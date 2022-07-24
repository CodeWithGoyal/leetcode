class Solution {
    class Pair{
        int i, j ,dist;
        Pair(int i,int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[maze.length][maze[0].length];
        queue.add(new Pair(entrance[0],entrance[1],0));
        visited[entrance[0]][entrance[1]] = true;
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
            for(int d[] : dir){
                int i = p.i + d[0];
                int j = p.j + d[1];
                if(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length) { 
                    if(p.i != entrance[0] || p.j != entrance[1])
                        return p.dist;
                    
                    continue;
                }
                if(!visited[i][j] && maze[i][j] == '.') 
                {
                    // System.out.println(i + " " + j);
                    visited[i][j] = true;
                queue.add(new Pair(i,j,p.dist+1));}
            }
        }
        return -1;
    }
}