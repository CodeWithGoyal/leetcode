class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int temp[] = new int[26];
        for(int i = 0; i < p.length(); i++){
            // count[p.charAt(i) - 'a']++;
            temp[p.charAt(i) - 'a']++;
        }
        int start = 0;
        int len = p.length();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(temp[s.charAt(i) - 'a'] == 0){
                if(s.charAt(i) == s.charAt(start)){
                    start++;
                }
                else{
                    while(start < i && temp[s.charAt(i) - 'a'] == 0){
                        temp[s.charAt(start++) - 'a']++;
                    }
                    if(start == i && temp[s.charAt(i) - 'a'] == 0) start++;
                    if(temp[s.charAt(i) - 'a'] != 0){
                        temp[s.charAt(i) - 'a']--;
                        
                    }
                }
                
            }
            else{
                temp[s.charAt(i) - 'a']--;
            }
            if(i - start == len - 1){
                res.add(start);
            }
        }
        return res;
    }
}