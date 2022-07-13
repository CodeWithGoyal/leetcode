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
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int K; 
            K = Integer.parseInt(br.readLine());
            
            
            int[] Arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.kthLargest(N, K, Arr);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long presum[] = new long[N];
        presum[0] = Arr[0] + 0l;
        pq.add(Arr[0] + 0l);
        for(int i = 1; i < N; i++){
            if(pq.size() < K){ pq.add(Arr[i]+0l);}
            else{
                if(pq.peek() < Arr[i]){
                    pq.remove();
                    pq.add(Arr[i]+0l);
                }
            }
            presum[i] = presum[i-1] + Arr[i];
        }
        for(int len = 2; len <= N; len++){
            int i = 0;
            while(i + len -1 < N){
                int j = i + len -1;
                long sum = (i == 0? presum[j]: presum[j] - presum[i-1]);
                if(pq.size() < K){ pq.add(sum);}
                else{
                    if(pq.peek() < sum){
                        pq.remove();
                        pq.add(sum);
                    }
                }
                i++;
            }
        }
        return (int)((long)pq.peek());
    }
}
        
