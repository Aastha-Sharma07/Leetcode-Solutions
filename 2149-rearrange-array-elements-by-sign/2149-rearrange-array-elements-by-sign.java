class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos_idx = 0;
        int neg_idx = 1;
        int [] res = new int[nums.length];

        for(int num:nums){
            if(num>=0){
                res[pos_idx] = num;
                pos_idx += 2;
            }else{
                res[neg_idx] = num;
                neg_idx += 2;
            }
        }
        return res;
    }
}