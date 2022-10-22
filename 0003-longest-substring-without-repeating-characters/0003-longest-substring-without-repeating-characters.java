class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int count[] = new int[256];
        int start = 0, res = 1;
        for(int i = 0; i < s.length(); i++){
            while(count[s.charAt(i)] == 1){
                count[s.charAt(start++)]--;
            }
            count[s.charAt(i)]++;
            res = Math.max(res, i - start+1);
        }
        return res;
    }
}