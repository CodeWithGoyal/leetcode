class Solution {
    private boolean dfs(int grid1[][],int grid2[][],int i,int j){
        if(i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0){
            return true;
        }
        boolean r = true;
        if(grid1[i][j] != 1) {r = false;}
        grid2[i][j] = 0;
        boolean res = dfs(grid1,grid2,i+1,j) & dfs(grid1,grid2,i-1,j) & dfs(grid1,grid2,i,j-1) & dfs(grid1,grid2,i,j+1);
        return res & r;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 1){
                    // System.out.println(i + " " + j);
                    if(dfs(grid1,grid2,i,j)){ count++;}
                }
            }
        }
        return count;
    }
}