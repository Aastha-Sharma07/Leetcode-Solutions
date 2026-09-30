class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    private void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        // Take
        current.add(nums[index]);
        solve(index+1,nums,current,ans);

        current.remove(current.size()-1);

        solve(index+1,nums,current,ans);
    }
}