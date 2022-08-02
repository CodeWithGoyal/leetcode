class Solution {
    class Pair{
        int i, j,val;
        Pair(int i, int j,int v){
            this.i = i;
            this.j = j;
            val = v;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Pair p1, Pair p2){
                return p1.val - p2.val;
            }
        });
        boolean visited[][] = new boolean[matrix.length][matrix.length];
        pq.add(new Pair(0,0,matrix[0][0]));
        while(k > 1){
            Pair p = pq.remove();
            if(p.i + 1 < matrix.length && visited[p.i+1][p.j] == false){
                visited[p.i+1][p.j] = true;
                pq.add(new Pair(p.i+1,p.j,matrix[p.i+1][p.j]));
            }
            if(p.j + 1 < matrix.length && visited[p.i][p.j+1] == false){
                visited[p.i][p.j+1] = true;
                pq.add(new Pair(p.i,p.j+1,matrix[p.i][p.j+1]));
            }
            k--;
        }
        Pair p = pq.peek();
        return matrix[p.i][p.j];
    }
}