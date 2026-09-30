class Solution {
    static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenWays = power(5,evenPositions);
        long oddWays = power(4,oddPositions);

        return (int)((evenWays*oddWays)%MOD);
        
    }

    private long power(long x, long n){
        if(n==0){
            return 1;
        }

        long half = power(x,n/2);
        long result = (half*half)%MOD;

        if(n%2==1){
            result = (result*x)%MOD;
        }

        return result;
    }
}