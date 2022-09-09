class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solve(nums,0,new ArrayList<>(),res);
        return res;
    }
    private void solve(int nums[], int i, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int j = i; j < nums.length; j++){
            if(j == i || nums[j] != nums[j-1]){
                list.add(nums[j]);
                solve(nums,j+1,list,res);
                list.remove(list.size()-1);
            }
        }
    }
}