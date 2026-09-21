class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int currH = 0;
        int maxArea=0;
        int height,width;

        for(int i=0;i<=n;i++){
            height = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && height<heights[stack.peek()]){
                currH= heights[stack.pop()];
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i-stack.peek()-1;
                }
                int Area = currH*width;
                maxArea = Math.max(maxArea,Area);
            }
            if(i<n){
                stack.push(i);
            }
        }
        return maxArea;
    }
}