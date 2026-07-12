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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p==null && q!=null) || (q==null && p!=null))
            return false;    

        boolean isLeftSubTreeSame = isSameTree(p.left,q.left);
        boolean isRightSubTreeSame = isSameTree(p.right,q.right);
        int pValue = p==null?0:p.val;
        int qValue = q==null?0:q.val;    
        return isLeftSubTreeSame && isRightSubTreeSame && pValue==qValue;
    }
}
