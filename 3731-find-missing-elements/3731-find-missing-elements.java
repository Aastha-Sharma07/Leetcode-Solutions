import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int start = nums[0];
        int end = nums[nums.length-1];

        for(int i=start;i<=end;i++){
            map.put(i,0);
        }
        for(int i=0;i<nums.length;i++){
                map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (int i = start; i <= end; i++) {
            if (map.get(i) == 0) {
                result.add(i);
            }
        }
        return result;
        
    }
}