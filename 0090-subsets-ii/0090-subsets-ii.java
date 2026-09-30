class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, nums, current, ans);
        return ans;
    }

    private void solve(int idx, int[] nums,
                       List<Integer> current,
                       List<List<Integer>> ans) {

        ans.add(new ArrayList<>(current));

        for (int i = idx; i < nums.length; i++) {

            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            solve(i + 1, nums, current, ans);

            current.remove(current.size() - 1);
        }
    }
}