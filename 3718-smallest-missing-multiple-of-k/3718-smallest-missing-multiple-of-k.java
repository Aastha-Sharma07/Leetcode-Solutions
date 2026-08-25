class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(nums[i],i);
        }
        int j=1;
        while(j<n+1){
            int key = k*j;
            if(!map.containsKey(key)){
                return key;
            }
            j++;
        }
        return k*j;
    }
}