class Solution {
    public int pivotIndex(int[] nums) {
        int target = 0;

        for(int num:nums){
            target +=num;
        }

        int leftSum=0;
        int pivot;

        for(int i=0;i<nums.length;i++){
            target -= nums[i];
            if(target == leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}