class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int idx=0;idx<=n;idx++)
            graph.add(new ArrayList<>());

        boolean []visited = new boolean[n+1];    
        for(int []edge:edges) {
            //System.out.println("Edge::"+edge[0]+","+edge[1]);
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //printGraph(graph,n);

        for(int vertex=0;vertex<n;vertex++) {
            if(!visited[vertex]) {
                count++;
                dfs(graph,visited,vertex);
            }
        }
        return count;


    }

    public void printGraph(List<List<Integer>> graph, int n) {
        for(int vertex=0;vertex<n;vertex++) {
            System.out.print(vertex+"-->");
            for(int nbr:graph.get(vertex)) {
                System.out.print(nbr+",");
            }
            System.out.println();
        }
    }

    public void dfs(List<List<Integer>> graph, boolean []visited, int src) {
        if(visited[src])
            return;
        visited[src] = true;    
        for(int nbr:graph.get(src)) {
            if(!visited[nbr]) {
                dfs(graph,visited,nbr);
            }
        }
    }
}
