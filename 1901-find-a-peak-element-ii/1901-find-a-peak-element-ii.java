class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length;
        int cols = mat[0].length;

        int low=0;
        int high = row-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int maxCol = 0;

            for(int col=1;col<cols;col++){
                if(mat[mid][maxCol]<mat[mid][col]){
                    maxCol = col;
                }
            }

            int up = (mid>0)? mat[mid-1][maxCol]:-1;
            int down = (mid+1 < row)? mat[mid+1][maxCol]:-1;

            if(up<mat[mid][maxCol] && down<mat[mid][maxCol]){
                return new int[]{mid,maxCol};
            }else if(up>mat[mid][maxCol]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}