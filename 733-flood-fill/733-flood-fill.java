class Solution {
     void fill(int[][] image, int sr, int sc ,int m,int n, int i, int newColor){
        if(sr < 0 || sr >= m || sc < 0 || sc >= n){
            return;
        }
        if(image[sr][sc] != i){
            return;
        }
        if(image[sr][sc] == newColor) return;
        image[sr][sc] = newColor;
        int row[] = {1,-1,0,0};
        int col[] = {0,0,1,-1};
        for(int k = 0; k < 4; k++){
            fill(image,sr+row[k],sc+col[k],m,n,i,newColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        this.fill(image,sr,sc,image.length,image[0].length,image[sr][sc],newColor);
        return image;
    }
}