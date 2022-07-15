// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
        if(n == 1) return "1";
        String prev = lookandsay(n-1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < prev.length(); i++){
            if(prev.charAt(i) != prev.charAt(i-1)){
                sb.append(String.valueOf(count));
                sb.append(prev.charAt(i-1));
                count = 1;
            }
            else count++;
        }
        sb.append(String.valueOf(count));
        sb.append(prev.charAt(prev.length() -1));
        return sb.toString();
    }
}
