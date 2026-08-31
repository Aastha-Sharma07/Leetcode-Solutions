class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        int limit = n/3+1;

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i]) == limit){
                res.add(nums[i]);
            }

            if(res.size() == 2){
                break;
            }
        }
        return res;
    }
}