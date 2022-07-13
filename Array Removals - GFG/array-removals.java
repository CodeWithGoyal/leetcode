// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int max = 1;
        for(int i = 0; i < n-1; i++){
            int x = binarySearch(arr,i,arr[i] + k);
            max = Math.max(max,x - i + 1);
        }
        return n - max;
    }
    int binarySearch(int arr[],int i, int x){
        int l = i, r = arr.length -1, ans = i;
        while(l <= r){
            int mid = (l + r)/2;
            if(arr[mid] < x){
                ans = mid;
                l = mid + 1;
            }
            else r = mid -1;
        }
        return ans;
    }
}