// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transfigure (A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transfigure (String A, String B)
    {
    	// Your code goes here.
    	int arr[] = new int[256];
    	for(int i = 0; i < A.length(); i++){
    	    arr[A.charAt(i)]++;
    	    arr[B.charAt(i)]--;
    	}
    	for(int i : arr)
    	    if(i != 0) return -1;
    	int i = A.length() -1, j = i, ans = 0;
    	while(i >= 0 && j >= 0){
    	    if(A.charAt(i) != B.charAt(j)){
    	        i--;
    	        ans++;
    	    }
    	    else{
    	        i--;
    	        j--;
    	    }
    	}
    	return ans;
    }
}