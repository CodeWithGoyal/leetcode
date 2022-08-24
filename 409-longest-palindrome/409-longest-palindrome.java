class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        int count[] = new int[26];
        int count2[] = new int[26];
        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                count[c - 'a']++;
            }
            else{
                count2[c - 'A']++;
            }
        }
        int res = 0, temp = 0;
        for(int i : count){
            res += i - (i % 2);
            if(i % 2 == 1){
                temp = 1;
            }
        }
        for(int i : count2){
            res += i - (i % 2);
            if(i % 2 == 1){
                temp = 1;
            }
        }
        return res + temp;
    }
}