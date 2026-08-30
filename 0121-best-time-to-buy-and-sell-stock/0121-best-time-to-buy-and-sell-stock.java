class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int num : prices){
            min = Math.min(min,num);
            max = Math.max(max, num-min);
        }
        return max;
    }
}