class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int []result = new int[n];
        int left = 0, right = n-1, k = n-1;

        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[k] = nums[left]*nums[left];
                left++;
            }
            else{
                result[k] = nums[right]*nums[right];
                right--;
            }
            k--;
        }
        return result;
    }
}