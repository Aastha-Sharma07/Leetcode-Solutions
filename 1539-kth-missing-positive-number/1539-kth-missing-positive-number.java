import java.util.*;

class Solution {
    public int findKthPositive(int[] arr, int k) {

        boolean[] nums = new boolean[arr[arr.length - 1] + 1];

        Arrays.fill(nums, true);

        for (int num : arr) {
            nums[num] = false;
        }

        for (int i = 1; i < nums.length; i++) {

            if (nums[i]) {
                k--;

                if (k == 0) {
                    return i;
                }
            }
        }

        return arr[arr.length - 1] + k;
    }
}