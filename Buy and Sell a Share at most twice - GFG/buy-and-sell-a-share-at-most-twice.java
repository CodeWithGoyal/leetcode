// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        int lprofit[] = new int[n];
        int profit = 0;
        int buy = price[0], sell = price[0];
        lprofit[0] = 0;
        for(int i = 1; i < n; i++){
            lprofit[i] = lprofit[i-1];
            if(price[i] > sell){
                lprofit[i] = Math.max(lprofit[i],price[i] - buy);
                sell = price[i];
            }
            else if(price[i] < buy){
                buy = price[i];
                sell = price[i];
            }
        }
        buy = price[n-1];
        sell = price[n - 1];
        int ans = 0;
        for(int i = n -1; i >= 0; i--){
            if(price[i] <= buy){
                buy = price[i];
                ans = Math.max(sell - buy + lprofit[i], ans);
            }
            else if(price[i] > sell) {
                sell = price[i];
                buy = price[i];
            }
        }
        return ans;
    }
}
        
