class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        for(int i = 1; i < neededTime.length; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                time += Math.min(neededTime[i],neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i],neededTime[i-1]);
            }
        }
        return time;
    }
}