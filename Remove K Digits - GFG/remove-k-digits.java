//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        Stack<Character> st = new Stack<>();
        int len = S.length();
        for(int i = 0;i < len; i++){
            while(!st.isEmpty() && S.charAt(i) < st.peek() && K > 0){
                st.pop();
                K--;
            }
            if(S.charAt(i) == '0' && st.isEmpty()){
                
            }
            else{
                st.push(S.charAt(i));
            }
        }
        while(K > 0 && st.isEmpty() == false){
            st.pop();
            K--;
        }
        StringBuilder res = new StringBuilder();
        if(st.isEmpty()) res.append("0");
        while(st.isEmpty() == false){
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}