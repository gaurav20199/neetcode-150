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
        fetchHeight(root,result);
        return result.diameter;
    }

    public int fetchHeight(TreeNode node,Result result) {
        if(node==null)
            return 0;  

        int maxLeftHeight = fetchHeight(node.left,result);
        int maxRightHeight = fetchHeight(node.right,result);
        int currentDiameter = result.getDiameter();
        int maxDiameter = Math.max(maxLeftHeight+maxRightHeight,currentDiameter);
        result.setDiameter(maxDiameter);
        return Math.max(maxLeftHeight,maxRightHeight)+1;


    }
}
