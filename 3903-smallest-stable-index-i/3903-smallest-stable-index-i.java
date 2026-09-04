class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] right_min = new int[n];
        right_min[n-1] = nums[n-1];

        int max = Integer.MIN_VALUE;

        for(int i=n-2; i>=0; i--){
            right_min[i] = Math.min(nums[i],right_min[i+1]);
        }

        for(int i=0; i<n; i++){
            max = Math.max(max,nums[i]);

            int score = max-right_min[i];

            if(score<=k){
                return i;
            }
        }
        return -1;
    }
}