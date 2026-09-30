class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,target,candidates,current,ans);
        return ans;
    }

    private void solve(int idx, int target, int[] candidates, List<Integer> current, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            if(i>idx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }

            current.add(candidates[i]);
            solve(i+1,target-candidates[i],candidates,current,ans);
            current.remove(current.size()-1);
        }
    }
}