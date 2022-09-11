class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,n,"",res);
        return res;
    }
    public void helper(int open, int close, String temp,List<String> res){
        if(open == 0 && close == 0){
            res.add(new String(temp));
            return;
        }
        if(open != 0){
            helper(open - 1, close, temp + '(', res);
        }
        if(close > open){
            helper(open, close - 1,temp + ')' , res);
        }
    }
}