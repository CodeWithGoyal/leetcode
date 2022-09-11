class Solution {
    class Engineer{
        int speed,efficiency;
        Engineer(int speed, int efficiency){
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        ArrayList<Engineer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Engineer(speed[i],efficiency[i]));
        }
        list.sort((a,b) -> b.efficiency - a.efficiency);
        PriorityQueue<Engineer> pq = new PriorityQueue<>((a,b) -> a.speed - b.speed);
        long res = 0,sum = 0;
        
        for(Engineer newGuy : list){
            if(pq.size() == k){
                sum -= pq.remove().speed;
            }
            pq.add(newGuy);
            sum += newGuy.speed;
            res = Math.max(res,sum*newGuy.efficiency);
        }
        return (int) (res % 1000000007);
    }
}