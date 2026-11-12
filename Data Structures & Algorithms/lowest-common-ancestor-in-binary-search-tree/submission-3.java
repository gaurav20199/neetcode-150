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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return p;

        return findLowestCommonAncestor(root,p,q);    

    }


    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p==null && q==null) || root==null)
            return null;

        System.out.println(root.val);

        if(root.val==p.val || root.val==q.val)
            return root;

        if(Math.max(p.val,q.val)<root.val)
            return findLowestCommonAncestor(root.left,p,q);

        else if(Math.min(p.val,q.val)>root.val)
            return findLowestCommonAncestor(root.right,p,q);          
            
        return root;        
    }

}
