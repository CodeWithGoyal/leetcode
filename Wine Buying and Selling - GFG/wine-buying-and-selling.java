// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int ans = g.wineSelling(a,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


 // } Driver Code Ends
//User function Template for Java


class Solution {
    int wineSelling(int A[],int N){
        // code 
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < N; i++){
            int x = A[i];
            while(queue.isEmpty() == false && x != 0 && A[queue.peek()]*x < 0){
                if(x < 0){
                    int m = Math.min(-x,A[queue.peek()]);
                    res += m*(i - queue.peek());
                    A[queue.peek()] -= m;
                    A[i] += m;
                    x = A[i];
                }
                else{
                    int m = Math.min(x,-A[queue.peek()]);
                    res += m*(i - queue.peek());
                    A[queue.peek()] += m;
                    A[i] -= m;
                    x = A[i];
                }
                if(A[queue.peek()] == 0){
                    queue.remove();
                }
            }
            if(x != 0){
                queue.add(i);
            }
        }
        return res;
    }
}

// { Driver Code Starts.  // } Driver Code Ends