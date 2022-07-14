// { Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            TreeSet<String> ans = new TreeSet<String>();
            ans = ob.allPossibleSubsequences(S);
            Iterator it = ans.iterator();
            if (ans.size() == 0) {
                System.out.print(-1);
            } else
                while (it.hasNext()) {
                    System.out.print(it.next() + " ");
                }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function template for Java

class Solution {
    static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    static TreeSet<String> allPossibleSubsequences(String s) {
        // code here
        TreeSet<String> set = new TreeSet<>();
        solve(s,s.length() -1,"",set);
        return set;
    }
    static void solve(String s, int i, String str, TreeSet<String> set){
        if(str.length() == 0){
            for(int j = i; j >= 0; j--){
                if(!isVowel(s.charAt(j))){
                    solve(s,j-1,s.charAt(j) + str,set);
                }
            }
        }
        else{
            if(isVowel(str.charAt(0))) set.add(new String(str));
            for(int j = i; j >= 0; j--){
                solve(s,j-1,s.charAt(j) + str, set);
            }
            
        }
    }
}