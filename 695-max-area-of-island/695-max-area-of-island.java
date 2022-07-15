class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = 0;
                    area += helper(grid,i,j);
                    maxArea = Math.max(maxArea, area);
                }
            }      
        }
        return maxArea;
    }
    public int helper(int[][] grid, int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = -1;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int area = 1;
        for(int[] direction : directions){
            area+= helper(grid,i+direction[0],j+direction[1]);
        }
        return area;
    }
}