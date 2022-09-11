class Solution {
    public boolean dfs(char[][]board,int row, int col, String word, int charIndex){
        if(charIndex >= word.length()) return true; 
        if(row < 0 || col < 0 || row >= board.length || col>= board[0].length || board[row][col] != word.charAt(charIndex)){
            return false;
        }
        // isVisited[row][col] = true;
        char temp = board[row][col];
        board[row][col] = ' ';
        if(dfs(board,row+1,col,word,charIndex+1) || dfs(board,row-1, col,word,charIndex + 1)|| dfs(board,row,col+1,word,charIndex+1)||dfs(board,row,col-1, word,charIndex+1)){
            return true;
        }
        // isVisited[row][col] = false;
        board[row][col] = temp;
        return false;
    
    }
    public boolean exist(char[][] board, String word) {
        
        boolean isExist = false;
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    // boolean isVisited[][] = new boolean[board.length][board[0].length];
                    isExist = dfs(board,i,j,word,0);
                    if(isExist){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}