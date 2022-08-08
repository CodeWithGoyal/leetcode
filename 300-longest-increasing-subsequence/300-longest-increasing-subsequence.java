class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(list.isEmpty()){
                list.add(nums[i]);
            }
            else{
                if(list.get(list.size() -1) < nums[i]){
                    list.add(nums[i]);
                }
                else{
                    int j = 0;
                    for(j = 0; j < list.size() && list.get(j) < nums[i]; j++);
                    if(list.get(j) == nums[i]){
                        continue;
                    }
                    list.set(j,nums[i]);
                }
            }
        }
        return list.size();
    }
}