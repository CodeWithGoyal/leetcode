class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        addSubset(res, new ArrayList(), nums, 0);
        return res;
    }
    public void addSubset(List<List<Integer>> res, List<Integer> list, int[] nums, int idx){
        res.add(new ArrayList(list));
        for(int i = idx; i < nums.length; i++){
            list.add(nums[i]);
            addSubset(res,list,nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}