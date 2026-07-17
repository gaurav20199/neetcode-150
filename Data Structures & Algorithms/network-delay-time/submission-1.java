class Solution {
    class Pair implements Comparable<Pair> {
        int src;
        int dest;
        int cost;

        public Pair(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Pair other) {
            return this.cost-other.cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<List<Pair>> graph = new ArrayList<>();
        boolean []visited = new boolean[n+1];
        for(int idx=0;idx<=n;idx++)
            graph.add(new ArrayList<>());

        for(int []arr:times) {
            graph.get(arr[0]).add(new Pair(arr[0],arr[1],arr[2]));
        }
        int []res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k] = 0;
        pq.add(new Pair(0,k,0));
        while(!pq.isEmpty()) {
            Pair removedPair = pq.remove();
            if (visited[removedPair.dest]) 
                continue; 
            
            visited[removedPair.dest] = true;
            addToPriorityQueue(graph,pq,removedPair.dest,visited,res);
        }
        int ans = 0;
         for(int idx=1;idx<=n;idx++) {
            if (res[idx] == Integer.MAX_VALUE) 
                return -1;
            ans = Math.max(ans, res[idx]);
        }
        return ans;    
    }

    public void addToPriorityQueue(List<List<Pair>> graph, PriorityQueue<Pair> pq, int src,boolean []visited,int []res) {  
        for(Pair nbr:graph.get(src)) {
            System.out.println(nbr.src+","+nbr.dest+","+nbr.cost);
            if(!visited[nbr.dest] && res[nbr.src] + nbr.cost < res[nbr.dest]) {
                res[nbr.dest] = res[nbr.src] + nbr.cost;
                pq.add(new Pair(nbr.src,nbr.dest,res[nbr.dest]));
            }
        } 
    }


}
