class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = t.length();
        for(int i = 0; i < len; i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        int l = 0, r = 0;
        HashMap<Character,Integer> windmap = new HashMap<>();
        int req = map.size();
        int curr_window = 0;
        int  res[] = {-1,0,0};
        while(r < s.length()){
            windmap.put(s.charAt(r), windmap.getOrDefault(s.charAt(r),0) + 1);
            if(map.containsKey(s.charAt(r)) && windmap.get(s.charAt(r)).intValue() == map.get(s.charAt(r)).intValue()){
                curr_window++;
            }
            while(l <= r && curr_window == req){
                if(res[0] == -1 || r - l + 1 < res[0]){
                    res[0] = r - l + 1;
                    res[1] = l;
                    res[2] = r;

                }
                char c = s.charAt(l);
                windmap.put(c,windmap.get(c) - 1);
                if(map.containsKey(c) && map.get(c) > windmap.get(c)){
                    curr_window--;
                }
                l++;
            }
            r++;
        }
        return res[0] == -1?"":s.substring(res[1],res[2]+1);
    }
}