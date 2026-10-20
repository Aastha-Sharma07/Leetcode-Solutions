class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] drop = new int[n];

        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        suffMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        for (int i = 1; i < n; i++) {
            drop[i] = drop[i - 1]
                    + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int l = 0; l < n; l += k) {
                int r = l + k - 1;

                int descents = drop[r] - drop[l];
                if (nums[r] > nums[l]) {
                    descents++;
                }

                if (descents > 1 ||
                    prefMax[l] > suffMin[l]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
