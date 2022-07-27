class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int len = beginWord.length();
        for(String word : wordList){
            for(int i = 0; i < len; i++){
                String newWord = word.substring(0,i) + '*' + word.substring(i+1,len);
                ArrayList<String> list = map.getOrDefault(newWord,new ArrayList<>());
                list.add(word);
                map.put(newWord,list);
            }
        }
        
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while(!queue.isEmpty()){
            Pair<String,Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i = 0; i < len; i++){
                String newWord = word.substring(0,i) + '*' + word.substring(i+1,len);
                for(String str : map.getOrDefault(newWord,new ArrayList<>())){
                    if(str.equals(endWord)){
                        return level + 1;
                    }
                    if(visited.contains(str) == false){
                        visited.add(str);
                        queue.add(new Pair(str,level + 1));
                    }
                }
            }
        }
        return 0;
    }
}