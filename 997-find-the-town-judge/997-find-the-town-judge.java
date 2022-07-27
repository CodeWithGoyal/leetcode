class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n+1];
        boolean temp[] = new boolean[n + 1];
        for(int arr[] : trust){
            temp[arr[0]] = true;
            indegree[arr[1]]++;
        }
        for(int i = 1; i <= n; i++){
            if(indegree[i] == n - 1 && temp[i] == false){
                return i;
            }
        }
        return -1;
    }
}