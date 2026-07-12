class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph  = new ArrayList<>();
        for(int idx=0;idx<=numCourses;idx++)
            graph.add(new ArrayList<>());

        boolean []visited = new boolean[numCourses+1];
        boolean []dfsVisited = new boolean[numCourses+1];

        for(int []arr:prerequisites) {
            graph.get(arr[1]).add(arr[0]);
        }
         for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && hasCycle(graph, visited, dfsVisited, i)) {
                return false; 
            }
        }
        return true;
    }

    public boolean hasCycle(List<List<Integer>> graph, boolean []visited, boolean []dfsVisited, int src) {
        if (dfsVisited[src]) 
            return true;
        if (visited[src]) 
            return false;

        dfsVisited[src] = true;
        visited[src] = true;       
        for(int nbr:graph.get(src)) {
            if(hasCycle(graph,visited,dfsVisited,nbr))
                return true;
        }
        dfsVisited[src] = false;
        return false;
    }
}
