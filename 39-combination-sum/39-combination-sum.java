class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates,target,res,new ArrayList<>(), 0);
        return res;
    }
    void solve(int candidates[], int target, List<List<Integer>> res, List<Integer> list, int i){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i == candidates.length) return;
        if(target >= candidates[i]){
            list.add(candidates[i]);
            solve(candidates,target - candidates[i], res,list,i);
            list.remove(list.size() -1);
        }
        solve(candidates,target,res,list,i+1);
    }
}