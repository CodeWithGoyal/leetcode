class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        permutation(nums,0,res,new ArrayList<>(),set);
        return res;
    }
    private void permutation(int nums[], int i, List<List<Integer>> res, List<Integer> list,HashSet<List<Integer>> set){
        if(i == nums.length){
            if(!set.contains(list)){
                set.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[i]);
        permutation(nums, i + 1, res,list,set);
        list.remove(list.size() -1);
        for(int j = i + 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                list.add(nums[i]);
                permutation(nums,i + 1, res,list,set);
                list.remove(list.size() -1);
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}