class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int j = 0;

            // Step 1: find nums1[i] in nums2
            while (j < nums2.length && nums2[j] != nums1[i]) {
                j++;
            }

            // Step 2: find next greater element
            int k = j + 1;
            while (k < nums2.length && nums2[k] <= nums1[i]) {
                k++;
            }

            // Step 3: store result
            if (k < nums2.length) {
                ans[i] = nums2[k];
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}