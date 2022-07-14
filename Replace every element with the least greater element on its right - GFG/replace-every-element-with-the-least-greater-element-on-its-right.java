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
            ArrayList<Integer> res = obj.findLeastGreater(n, arr);
            
            IntArray.print(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
        static int[] nextGreaterIndex(ArrayList<int[]> temp)
    {
        int n = temp.size();
        // initially result[i] for all i is -1
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            // if the stack is empty or this index is
            // smaller than the index stored at top of the
            // stack then we push this index to the stack
            if (stack.empty()
                || temp.get(i)[1] < stack.peek())
                stack.push(temp.get(
                    i)[1]); // notice temp[i].second is
                            // the index
            // else this index (i.e. temp[i].second) is
            // greater than the index stored at top of the
            // stack we pop all the indexes stored at
            // stack's top and for all these indexes we make
            // this index i.e. temp[i].second as their next
            // greater index
            else {
                while (!stack.empty()
                       && temp.get(i)[1] > stack.peek()) {
                    res[stack.peek()] = temp.get(i)[1];
                    stack.pop();
                }
                // after that push the current index to the
                // stack
                stack.push(temp.get(i)[1]);
            }
        }
        // now res will store the next least greater indexes
        // for each and every indexes stored at
        // temp[i].second for all i
        return res;
    }
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        ArrayList<int[]> temp = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            temp.add(new int[] { arr[i], i });
        }
        // we sort the temp according to the first of the
        // pair i.e value
        Collections.sort(temp, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
 
        // now indexes vector will store the next greater
        // index for each temp[i].second index
        int[] indexes = nextGreaterIndex(temp);
        // we initialize a result vector with all -1
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            // now if there is no next greater index after
            // the index temp[i].second the result will be
            // -1 otherwise the result will be the element
            // of the array arr at index
            // indexes[temp[i].second]
            if (indexes[temp.get(i)[1]] != -1)
                res[temp.get(i)[1]]
                    = arr[indexes[temp.get(i)[1]]];
        }
        // return the res which will store the least greater
        // element of each and every element in the array at
        // its right side
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : res) list.add(i);
        return list;
    }
}
        
