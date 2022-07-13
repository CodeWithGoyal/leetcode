// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends

class Pair implements Comparable<Pair>{
    int val, count;
    Pair(int v, int c){
        val = v;
        count = c;
    }
    @Override
    public int compareTo(Pair p1){
        return this.val - p1.val;
    }
}
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(new Pair(price[i],i+ 1));
        }
        // System.out.println(pq.size());
        int res = 0;
        while(!pq.isEmpty() &&  pq.peek().val <= k){
            Pair x = pq.remove();
            int min = Math.min(k,x.val*x.count);
            int c = min/x.val;
            res += c;
            k-= c*x.val;
        }
        return res;
    }
}
        
