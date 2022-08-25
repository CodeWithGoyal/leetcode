class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = Integer.MIN_VALUE, maj2 = Integer.MAX_VALUE, c1 = 0, c2 = 0;
        for(int i : nums){
            if(i == maj1){
                c1++;
            }
            else if(i == maj2){
                c2++;
            }
            else if(c1 == 0){
                maj1 = i;
                c1 = 1;
            }
            else if(c2 == 0){
                maj2 = i;
                c2 = 1;
            }
            else{
                c1--;
                c2--;
                // maj1 = Integer.MIN_VALUE;
                // maj2 = Integer.MAX_VALUE;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i : nums){
            if(i == maj1){
                c1++;
            }
            else if(i == maj2){
                c2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        System.out.println(maj1 + " " + maj2);
        if(c1 > nums.length/3){
            list.add(maj1);
        }
        if(c2 > nums.length/3){
            list.add(maj2);
        }
        return list;
    }
}