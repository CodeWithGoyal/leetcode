class Solution {
    class Pair{
        String str;
        int count = 0;
        Pair(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        ArrayList<Pair> list =  new ArrayList<>();
        for(Map.Entry<String,Integer> e : map.entrySet()){
            list.add(new Pair(e.getKey(),e.getValue()));
        }
        Collections.sort(list,new Comparator<>(){
            public int compare(Pair p1, Pair p2){
                if(p2.count == p1.count){
                    return p1.str.compareTo(p2.str);
                }
                return p2.count - p1.count;
            }
        });
        int i = 0;
        List<String> res = new ArrayList<>();
        while(k-- > 0){
            res.add(list.get(i++).str);
        }
        return res;
    }
}