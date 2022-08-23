class Solution {
    public boolean isSubsequence(String s, String t) {
        return helper(s,t,s.length()-1,t.length()-1);
    }
    public boolean helper(String s, String t, int i, int j){
        if(i < 0) return true;
        if(j < 0) return i < 0? true:false;
        if(s.charAt(i) == t.charAt(j)){
            return helper(s,t,i-1,j-1);
        }
        else{
            return helper(s,t,i,j-1);
        }
    }
}