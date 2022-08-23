class Solution {
    String helper(String str){
        HashMap<Character,Character> map = new HashMap<>();
        char c = 'a';
        int len = str.length();
        char arr[] = new char[len];
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                arr[i] = map.get(ch);
            }
            else{
                arr[i] = c;
                map.put(ch,c);
                c++;
            }
        }
        return String.valueOf(arr);
    }
    public boolean isIsomorphic(String s, String t) {
        s = helper(s);
        t = helper(t);
        return s.equals(t);
    }
}