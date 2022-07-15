// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {   
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String S){
        // code here
        Stack<Character> st = new Stack<>();
        int temp = 0,ans=0;
        for(char c : S.toCharArray()){
            if(c == '['){
                if(temp == 0)st.push('[');
                else{
                    ans += temp;
                    temp--;
                }
            } 
            else{
                if(st.isEmpty()){
                    temp++;
                }
                else st.pop();
            }
        }
        return ans + st.size()/2;
    }
}