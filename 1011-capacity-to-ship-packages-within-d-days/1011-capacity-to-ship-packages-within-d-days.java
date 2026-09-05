class Solution {
    private int daysReq(int[] weights,int mid){
        int days=1;
        int sum=0;

        for(int weight:weights){
            if (sum + weight > mid) {
            days++;
            sum = 0;
            }        

            sum += weight;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;

        for(int weight:weights){
            high += weight;
            low = Math.max(weight,low);
        }

        while(low<=high){
            int mid = low+(high-low)/2;
            int sum=0;

            int reqDays = daysReq(weights,mid);

            if(reqDays<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}