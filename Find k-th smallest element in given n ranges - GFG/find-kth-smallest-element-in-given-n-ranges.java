// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}


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
            
            
            int[][] range = IntMatrix.input(br, n, 2);
            
            
            int q; 
            q = Integer.parseInt(br.readLine());
            
            
            int[] queries = IntArray.input(br, q);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.kthSmallestNum(n, range, q, queries);
            
            IntArray.print(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        ArrayList<int[]> list = new ArrayList<>();
        for(int arr[] : range){
            list.add(arr);
        }
        Collections.sort(list,new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0] - b[0];
            }
        });
        ArrayList<Integer> l = new ArrayList<>();
        int s  = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = Math.max(s+1,list.get(i)[0]); j <= list.get(i)[1]; j++) l.add(j);
            s = Math.max(s,list.get(i)[1]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < q; i++){
            res.add(queries[i] -  1 < l.size() ? l.get(queries[i] - 1): -1);
        }
        return res;
    }
}
        
