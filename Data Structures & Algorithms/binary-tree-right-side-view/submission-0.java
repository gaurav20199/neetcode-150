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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        populateRightSideView(root,ans,0);
        return ans;
    }

    public void populateRightSideView(TreeNode node, List<Integer> res, int level) {
        if(node==null)
            return;

        if(level==res.size())
            res.add(node.val);

        populateRightSideView(node.right,res,level+1);
        populateRightSideView(node.left,res,level+1);    
    
    }
}
