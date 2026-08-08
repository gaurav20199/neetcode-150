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

    public class Result {
        private int diameter;
        public void setDiameter(int diameter) {
            this.diameter = diameter;
        }

        public int getDiameter() {
            return this.diameter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Result result = new Result();
        fetchDiameter(root,result);
        return result.getDiameter();
    }

    public int fetchDiameter(TreeNode node,Result result) {
        if(node==null)
            return 0;

        int leftHeight = fetchDiameter(node.left,result);
        int rightHeight = fetchDiameter(node.right,result);
        result.setDiameter(Math.max(result.getDiameter(),leftHeight+rightHeight));
        return Math.max(leftHeight,rightHeight)+1;
    }

    
}
