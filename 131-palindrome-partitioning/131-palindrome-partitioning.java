class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s,res,new ArrayList<>(),s.length() -1);
        return res;
    }
    void solve(String s, List<List<String>> res, List<String> list, int i){
        if(i < 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j = i; j >= 0; j--){
            String str = s.substring(j,i+1);
            if(isPalin(str)){
                list.add(0,str);
                solve(s,res,list,j-1);
                list.remove(0);
            }
        }
    }
    boolean isPalin(String s){
        int i = 0, j = s.length() -1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}