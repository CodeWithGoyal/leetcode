class Solution {
    private String transform(String s){
        HashMap<Character,Character> map = new HashMap<>();
        char c = 'a';
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch) == false){
                sb.append(c);
                map.put(ch,c);
                c++;
            }
            else{
                sb.append(map.get(ch));
            }
        }
        return sb.toString();
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String pat = transform(pattern);
        List<String> res = new ArrayList<>();
        for(String s : words){
            String temp = transform(s);
            if(temp.equals(pat)) res.add(s);
            // System.out.println(temp);
        }
        return res;
    }
}