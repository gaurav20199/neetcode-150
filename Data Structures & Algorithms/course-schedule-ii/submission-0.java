class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int idx=0;idx<=numCourses;idx++)
            graph.add(new ArrayList<>());

        for(int []prerequisite:prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean []visited = new boolean[graph.size()+1];
        boolean []dfsVisited = new boolean[graph.size()+1];
        Stack<Integer> dependencyOrder = new Stack<>();
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && hasCycle(graph, visited, dfsVisited, i,dependencyOrder))
                return new int[0];
        }

        int []res = new int[dependencyOrder.size()];
        int idx = dependencyOrder.size()-1;
        while(!dependencyOrder.isEmpty()) {
            res[idx--] = dependencyOrder.pop();
        }
        return res;
    }

    public boolean hasCycle(List<List<Integer>> graph, boolean []visited, boolean []dfsVisited, int src,Stack<Integer> dependencyOrder) {
        if (dfsVisited[src]) 
            return true;
        if (visited[src]) 
            return false;

        dfsVisited[src] = true;
        visited[src] = true;       
        for(int nbr:graph.get(src)) {
            if(hasCycle(graph,visited,dfsVisited,nbr,dependencyOrder))
                return true;
        }
        dfsVisited[src] = false;
        dependencyOrder.push(src); 
        return false;
    }

        
}
    

