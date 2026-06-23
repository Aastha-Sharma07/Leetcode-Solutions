class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while(left<right){
            int ht = Math.min(height[left],height[right]);
            int width = right-left;
            int currWater = ht*width;
            maxWater = Math.max(currWater,maxWater);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}