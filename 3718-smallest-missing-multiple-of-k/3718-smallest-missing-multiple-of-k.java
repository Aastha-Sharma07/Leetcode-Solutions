class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int j=1;
        while(j<=n){
            int multiple = k*j;
            
            if(!set.contains(multiple)){
                return multiple;
            }

            j++;
        }
        return k*j;
    }
}