class Solution {
    public boolean isPerfectSquare(int num) {
        int n = num/2;
        int start = 0;
        int end = n;

        if(num == 1){
            return true;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            long square = (long)mid*mid;
            if(square == num){
                return true;
            }
            else if(square < num){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;  
    }
}