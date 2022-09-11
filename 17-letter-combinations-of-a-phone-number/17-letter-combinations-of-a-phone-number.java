class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>(Arrays.asList('a','b','c')));
        list.add(new ArrayList<>(Arrays.asList('d','e','f')));
        list.add(new ArrayList<>(Arrays.asList('g','h','i')));
        list.add(new ArrayList<>(Arrays.asList('j','k','l')));
        list.add(new ArrayList<>(Arrays.asList('m','n','o')));
        list.add(new ArrayList<>(Arrays.asList('p','q','r','s')));
        list.add(new ArrayList<>(Arrays.asList('t','u','v')));
        list.add(new ArrayList<>(Arrays.asList('w','x','y','z')));
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        helper(digits,res,"",digits.length() -1,list);
        return res;
    }
    public void helper(String digits, List<String> res, String temp, int i, ArrayList<ArrayList<Character>> list){
        if(i < 0){
            res.add(new String(temp));
            return;
        }

        for(char c : list.get(digits.charAt(i) - '0')){
            helper(digits,res,c + temp,i-1,list);
        }
    }
}