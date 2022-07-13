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
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findMaxProduct(n, arr);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int findMaxProduct(int n, int[] arr) {
        // code here
        if(n == 1) return arr[0];
        long prod = 1, mod = 1000000007;
        long max = arr[0] < 0? arr[0]:-11,c0 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                c0++;
            }
            else{
                if(prod == 0) prod = 1;
                if(arr[i] < 0){
                    max = Math.max(max,arr[i]);
                }
                prod = (prod * arr[i])% mod;
            }
        }
        if(prod < 0){
            if(c0 == arr.length - 1 && c0 > 0) return 0;
            prod /= max;
        }
        
        return (int)(prod%mod);
    }
}
        
