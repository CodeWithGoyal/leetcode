class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            pq.add(e.getValue());
        }
        int x = arr.length/2;
        int ans = 0;
        while(x > 0){
            x -= pq.remove();
            ans++;
        }
        return ans;
    }
}