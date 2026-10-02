class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        int n = cardPoints.length;

        int size = n-k;
        int winSum = 0;

        for(int points:cardPoints){
            total += points;
        }

        for(int i=0; i<size; i++){
            winSum += cardPoints[i];
        }
        int minSum = winSum;

        for(int i=size; i<n; i++){
            winSum += cardPoints[i];
            winSum -= cardPoints[i-size];

            minSum = Math.min(winSum,minSum);
        }
        return total-minSum;
    }
}