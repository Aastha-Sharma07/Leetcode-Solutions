class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(0,target,candidates,current,ans);
        return ans;
    }

    private void solve(int idx, int target, int[] candidates, List<Integer> current, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(target<0 || idx == candidates.length){
            return;
        }

        current.add(candidates[idx]);
        solve(idx,target-candidates[idx],candidates,current,ans);

        current.remove(current.size()-1);

        solve(idx+1,target,candidates,current,ans);
    }
}