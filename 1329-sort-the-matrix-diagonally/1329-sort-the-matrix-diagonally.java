class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(map.containsKey(j-i) == false){
                    map.put(j-i,new PriorityQueue<>());
                }
                // map.put(j-i,mat[i][j]);
                map.get(j-i).add(mat[i][j]);
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = map.get(j-i).remove();
            }
        }
        return mat;
    }
}