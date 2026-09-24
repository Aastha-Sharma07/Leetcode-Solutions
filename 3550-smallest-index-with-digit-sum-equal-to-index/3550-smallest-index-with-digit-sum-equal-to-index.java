class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int n = nums.length;
            int x=nums[i];
            if(n>1){
                int sum=0;
                while(x>0){
                    int temp = x%10;
                    sum+=temp;
                    x /= 10;
                }
                if(sum == i)
                    return i;
            }
            else{
                if(nums[i] == i)
                    return i;        
            }
        }
        return -1;
    }
}