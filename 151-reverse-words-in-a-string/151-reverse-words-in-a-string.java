class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0, len = s.length();
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        j = i + 1;
        while(j < len){
            if(j >= 1 && s.charAt(j) == ' ' && s.charAt(j-1) != ' '){
                res.insert(0," " + s.substring(i,j));
                i = j + 1;
            }
            else if(s.charAt(j) == ' '){
                i = j + 1;
            }
            j++;
        }
        if(i < j){
            res.insert(0," " + s.substring(i,j));
        }
        res.deleteCharAt(0);
        return res.toString();
    }
}