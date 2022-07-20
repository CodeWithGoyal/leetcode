class Solution {
    public int numMatchingSubseq(String str, String[] words) {
        HashMap<Character, ArrayList<StringBuilder>> map = new HashMap<>();
        for(char c = 'a'; c <= 'z';c++){
            map.put(c,new ArrayList<>());
        }
        for(String s : words){
            map.get(s.charAt(0)).add(new StringBuilder(s));
        }
        int res = 0;
        for(char c : str.toCharArray()){
            int len = map.get(c).size();
            ArrayList<StringBuilder> list = map.get(c);
            for(int i = 0; i < len; i++){
                StringBuilder sb = list.get(0);
                if(sb.length() == 1){
                    res++;
                }
                else{
                    sb.deleteCharAt(0);
                    map.get(sb.charAt(0)).add(sb);
                }
                list.remove(0);
            }
        }
        return res;
    }
}