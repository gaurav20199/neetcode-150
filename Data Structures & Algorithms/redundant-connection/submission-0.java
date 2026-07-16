class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int idx=0;idx<=edges.length;idx++)
            graph.add(new ArrayList<>());

        for(int []edge:edges) {
            boolean []visited = new boolean[edges.length+1];
            if(hasPath(graph,visited,edge[0],edge[1]))
                return new int[]{edge[0],edge[1]};
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return new int[]{-1,-1};
    }

    public boolean hasPath(List<List<Integer>> graph, boolean []visited, int src, int target) {
        if(src==target)
            return true;
        visited[src] = true;
        for(int nbr: graph.get(src)) {
            if(!visited[nbr] && hasPath(graph,visited,nbr,target)) {
                return true;
            } 
        }
        return false;
    }
}
