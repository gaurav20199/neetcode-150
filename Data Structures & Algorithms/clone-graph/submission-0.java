/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        Node []visited = new Node[102];
        return dfs(node,visited);
    }

    public Node dfs(Node node, Node []visited) {
        if(visited[node.val]!=null)
            return visited[node.val];
        Node deepCopy = new Node(node.val);      
        visited[node.val] = deepCopy;
        for(Node neighbor:node.neighbors) {                
            deepCopy.neighbors.add(dfs(neighbor,visited));
        }        
        return deepCopy;
    }
}