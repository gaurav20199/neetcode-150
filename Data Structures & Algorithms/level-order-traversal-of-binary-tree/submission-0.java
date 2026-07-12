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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer,List<Integer>> levelToNodes = new HashMap<>();
        levelOrderTraversal(root,levelToNodes,0);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> nodeList:levelToNodes.values()) {
            res.add(nodeList);
        }
        return res;
    }

    public void levelOrderTraversal(TreeNode node,Map<Integer,List<Integer>> levelToNodes,int level) {
        if(node==null)
            return;

        List<Integer> res = levelToNodes.getOrDefault(level,new ArrayList<>());
        res.add(node.val);
        levelToNodes.put(level,res);
        levelOrderTraversal(node.left,levelToNodes,level+1);
        levelOrderTraversal(node.right,levelToNodes,level+1);

    }
}
