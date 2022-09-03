class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= 9; i++){
            queue.add(i);
        }
        for(int i = 0; i < n - 1; i++){
            int size = queue.size();
            while(size--> 0){
                     int x = queue.remove();
                int y = x % 10;
                if(y + k <= 9){
                    queue.add(x*10 + y + k);
                }
                if(y - k >= 0 && k != 0){
                    queue.add(x*10 + y - k);
                }
            }
        }
        int len = queue.size();
        int i = 0;
        int res[] = new int[len];
        while(!queue.isEmpty()){
            res[i++] = queue.remove();
        }
        return res;
    }
}