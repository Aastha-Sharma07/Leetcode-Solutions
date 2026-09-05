class Solution {
    private boolean canMake(int[] bloomDay,int day, int m, int k){
        int consecutive = 0;
        int bouq = 0;

        for(int flower:bloomDay){
            if(flower<=day){
                consecutive++;

                if(consecutive == k){
                    bouq++;
                    consecutive = 0;
                }
            }else{
                consecutive = 0;
            }

        }
        return bouq >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length){
            return -1;
        }

        int low = 1;
        int high = 0;

        for(int flower:bloomDay){
            high = Math.max(flower,high);
        }

        while(low<=high){
            int mid = low+(high-low)/2;

            if(canMake(bloomDay,mid,m,k)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}