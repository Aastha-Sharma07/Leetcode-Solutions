class Solution {
    public int[] shuffle(int[] nums, int n) {
       int start = 0;
       int mid = n;

       int[] res = new int[2*n];

       for(int i=0; i<2*n; i++){
        if(i%2 == 0){
            res[i] = nums[start];
            start++;
        }else{
            res[i] = nums[mid];
            mid++;
        }

       }
       return res;
    }
}