// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int row[] = {0,0,1,1,1,-1,-1,-1};
        int col[] = {1,-1,0,1,-1,0,1,-1};
        int n = grid.length;
        int m = grid[0].length;
        int len = word.length();
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == word.charAt(0)){
                    for(int ii = 0; ii < 8; ii++){
                        if(dfs(grid,i,j,word,0,row[ii],col[ii])){
                            list.add(new int[] {i,j});
                            break;
                        }
                    }
                    
                }
            }
        }
        int res[][] = new int[list.size()][];
        res = list.toArray(res);
        return res;
    }
    boolean dfs(char[][] grid, int i, int j, String word, int ind, int x, int y){
        if(ind >= word.length()) return true;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != word.charAt(ind)) 
            return false;
        char c = grid[i][j];
        grid[i][j] = '*';
        // int row[] = {0,0,1,1,1,-1,-1,-1};
        // int col[] = {1,-1,0,1,-1,0,1,-1};
        // for(int k = 0; k < 8; k++){
        //     if(dfs(grid,i + row[k], j + col[k],word,ind + 1)) return true;
        // }
        boolean res = dfs(grid,i+x,j+y,word,ind+1,x,y);
        grid[i][j] = c;
        return res;
    }
}