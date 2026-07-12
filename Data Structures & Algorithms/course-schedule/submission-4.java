class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph  = new ArrayList<>();
        for(int idx=0;idx<=numCourses;idx++)
            graph.add(new ArrayList<>());

        int []visited = new int[numCourses+1];
        //boolean []dfsVisited = new boolean[numCourses+1];

        for(int []arr:prerequisites) {
            graph.get(arr[1]).add(arr[0]);
        }
         for(int i = 0; i < numCourses; i++) {
            if(visited[i]==0 && hasCycle(graph, visited, i))
                return false; 
        }
        return true;
    }

    public boolean hasCycle(List<List<Integer>> graph, int []visited, int src) {
        if (visited[src]==1) 
            return true;
        if (visited[src]==2) 
            return false;

        visited[src] = 1;       
        for(int nbr:graph.get(src)) {
            if(hasCycle(graph,visited,nbr))
                return true;
        }
        visited[src] = 2;
        return false;
    }
}
