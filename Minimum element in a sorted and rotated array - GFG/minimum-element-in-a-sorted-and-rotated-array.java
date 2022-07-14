// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
        int l = 0, r = n - 1,ans = 1000000;
        while(l <= r){
            int mid = (l + r)/2;
            if(arr[mid] > arr[0] && arr[mid] > arr[n-1]){
                l = mid + 1;
            }
            else{
                r = mid -1;
            }
            ans = Math.min(ans,arr[mid]);
        }
        return ans;
    }
}
