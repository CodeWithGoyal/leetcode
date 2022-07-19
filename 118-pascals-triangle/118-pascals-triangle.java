class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for(int i = 1; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 1; j < i; j++){
                list.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}