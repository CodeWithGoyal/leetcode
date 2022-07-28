class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if(len1 != len2) return false;
        int count[] = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            count[c - 'a']--;
            if(count[c - 'a'] < 0) return false;
        }
        return true;
    }
}