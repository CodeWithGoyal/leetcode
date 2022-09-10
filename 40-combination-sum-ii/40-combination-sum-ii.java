class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates,target, res,new ArrayList<>(), 0);
        return res;
    }
    void solve(int candidates[],int target, List<List<Integer>> res, List<Integer> list, int i){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i == candidates.length) return;
        for(int j  = i; j < candidates.length; j++){
            if((j == i || candidates[j] != candidates[j-1]) && (target >= candidates[j])){
                list.add(candidates[j]);
                solve(candidates,target - candidates[j], res,list,j+1);
                list.remove(list.size()-1);
            }
        }
    }
}