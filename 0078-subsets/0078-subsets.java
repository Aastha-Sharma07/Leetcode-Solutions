class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0,nums,current,ans);
        return ans;
    }
    private void solve(int idx, int[]nums,List<Integer> current, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[idx]);
        solve(idx+1,nums,current,ans);
        current.remove(current.size()-1);

        solve(idx + 1, nums, current, ans);
    }
}