class Solution {
    private long totalHrs(int[] piles, int k){
        long hours = 0;

        for(int pile:piles){
            hours += (pile+k-1)/k;
        }

        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high = 0;

        for(int pile:piles){
            high = Math.max(pile,high);
        }

        while(low<=high){
            int mid = low+(high-low)/2;

            if(totalHrs(piles,mid)<=h){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}