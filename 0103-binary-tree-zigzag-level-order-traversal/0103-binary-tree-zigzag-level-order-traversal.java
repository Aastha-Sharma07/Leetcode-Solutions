/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null ){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> level  = new ArrayList<>();

            for(int i=0;i<sz;i++){
                TreeNode curr = q.remove();
                level.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(!leftToRight){
                Collections.reverse(level);
            }
            ans.add(level);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}