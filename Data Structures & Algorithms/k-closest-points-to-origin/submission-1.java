class Solution {
    private class Pair implements Comparable<Pair> {
        int xc;
        int yc;
        double distance;
        Pair(int xc, int yc, double distance) {
            this.xc = xc;
            this.yc = yc;
            this.distance = distance;
        }

        public int compareTo(Pair other) {
            return Double.compare(other.distance, this.distance);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int []ptArr:points) {
            double dist = Math.sqrt(Math.pow(Math.abs(ptArr[0]-0),2)+Math.pow(Math.abs(ptArr[1]-0),2));
            pq.add(new Pair(ptArr[0],ptArr[1],dist));
        }
        int [][]res = new int[k][2];
        int elementsToRemove = points.length-k;
        while(elementsToRemove-->0)
            pq.remove();

        int idx=0;
        while(!pq.isEmpty()) {
            Pair removedPair = pq.remove();
            res[idx][0] = removedPair.xc;
            res[idx++][1] = removedPair.yc;
        }
        return res; 

    }
}
