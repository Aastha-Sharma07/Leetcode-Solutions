import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        
        for(int num:nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }

        int [] arr = new int[max+1];
        
        for(int i:nums){
           arr[i]++; 
        }

        for(int i=min; i<=max; i++){
            if(arr[i] == 0){
                result.add(i);
            }
        }

        return result;
    }
}