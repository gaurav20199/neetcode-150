class Solution {
    public boolean validTree(int n, int[][] edges) {
       List<List<Integer>> graph = new ArrayList<>();
       for(int idx=0;idx<=n;idx++)
            graph.add(new ArrayList<>());

       for(int []edge:edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
       }
       boolean []visited = new boolean[n+1];
    //    for(int idx=0;idx<n;idx++) {
    //         if(!visited[idx] && hasCycle(graph,visited,-1,idx))
    //             return false;
    //    }
       if(hasCycle(graph,visited,-1,0))
            return false;
       for(int idx=0;idx<n;idx++)
            if(!visited[idx])
                return false;
       return true;

    }

     public boolean hasCycle(List<List<Integer>> graph, boolean []visited, int parent, int src) {
        visited[src] = true;
        for(int nbr:graph.get(src)) {
            // if(nbr==src)
            //     return true;
            if(visited[nbr] && nbr!=parent)
                return true;
            else if(!visited[nbr]) {
                if(hasCycle(graph,visited,src,nbr))
                    return true;
            }
        }
        return false;
    }
}
