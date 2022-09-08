class Solution {
    class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O' ){
                board[i][0] = '*';
                queue.add(new Pair(i,0));
            }
            if(board[i][board[0].length -1 ] == 'O'){
                board[i][board[0].length -1 ] = '*';
                queue.add(new Pair(i,board[0].length -1));
            }
        }
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O' ){
                board[0][i] = '*';
                queue.add(new Pair(0,i));
            }
            if(board[board.length -1][i] == 'O'){
                board[board.length -1][i] = '*';
                queue.add(new Pair(board.length -1,i));
            }
        }
        bfs(board,queue);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '*'){
                    board[i][j] = 'X';
                }
                else{
                    board[i][j] = 'O';
                }
            }
        }
    }
    void bfs(char board[][], Queue<Pair> queue){
        while(queue.isEmpty() == false){
            Pair p = queue.remove();
            int i = p.i;
            int j = p.j;
            if(i + 1 < board.length && board[i+1][j] == 'O'){
                board[i+1][j] = '*';
                queue.add(new Pair(i + 1, j));
            }
            if(i - 1 >= 0 && board[i-1][j] == 'O'){
                board[i-1][j] = '*';
                queue.add(new Pair(i-1,j));
            }
            if(j + 1 < board[0].length && board[i][j+1] == 'O'){
                board[i][j+1] = '*';
                queue.add(new Pair(i, j+1));
            }
            if(j - 1 >= 0 && board[i][j-1] == 'O'){
                board[i][j-1] = '*';
                queue.add(new Pair(i,j-1));
            }
        }
    }
}