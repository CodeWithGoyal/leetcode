// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        int count[] = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : count){
            if(i != 0) pq.add(i);
        }
        while(k > 0){
            pq.add(pq.remove() - 1);
            k--;
        }
        int ans = 0;
        for(int x : pq){
            ans += x*x;
        }
        return ans;
    }
}