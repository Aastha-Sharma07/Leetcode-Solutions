class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long total = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        int k = k1 + k2;

        if (k >= total) return 0;

        int[] freq = new int[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            int count = Math.min(freq[d], k);

            freq[d] -= count;
            freq[d - 1] += count;
            k -= count;
        }

        long ans = 0;

        for (int d = 1; d < freq.length; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}
