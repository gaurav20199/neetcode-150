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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedInteger = new ArrayList<>();
        inorderTraversal(root,sortedInteger);
        return fetchKthSmallest(sortedInteger,k);
    }

    public int fetchKthSmallest(List<Integer> sortedInteger, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int val:sortedInteger)
            pq.add(val);
        
        int loopSize = sortedInteger.size()-k;
        while(loopSize-->0)
            pq.remove();

        return pq.peek();        
    }

    public void inorderTraversal(TreeNode node, List<Integer> sortedInteger) {
        if(node==null)
            return;

        inorderTraversal(node.left,sortedInteger);
        sortedInteger.add(node.val);
        inorderTraversal(node.right,sortedInteger);    
    
    }
}
