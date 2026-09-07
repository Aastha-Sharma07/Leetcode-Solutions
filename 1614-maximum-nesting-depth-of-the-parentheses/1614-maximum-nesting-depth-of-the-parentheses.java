class Solution {
    public int maxDepth(String s) {
        int level = 0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                level++;
            }else if(s.charAt(i) == ')'){
                max=Math.max(max,level);
                level --;
            }
        }
        return max;
    }
}