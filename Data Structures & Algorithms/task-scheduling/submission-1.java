class Solution {

    class Pair implements Comparable<Pair> {
        private int freq;
        private int nextExecutionTime;
        public Pair(int freq, int nextExecutionTime) {
            this.freq = freq;
            this.nextExecutionTime = nextExecutionTime;
        }

        public int compareTo(Pair other) {
            return other.freq-this.freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int []freqArr = new int[26];
        for(int idx=0;idx<tasks.length;idx++)
            freqArr[tasks[idx]-'A']++;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Queue<Pair> queue = new LinkedList<>();
        for(int idx=0;idx<26;idx++) {
            int freq = freqArr[idx];
            if(freq!=0)
                pq.add(new Pair(freq,0));
        }
        int currTime = 0;
        while(!pq.isEmpty()  || !queue.isEmpty()) {
            currTime++;
            if(!pq.isEmpty()) {
                Pair currPair = pq.remove();
                currPair.freq--;
                currPair.nextExecutionTime = currTime+n;
                if(currPair.freq>=1)
                    queue.add(currPair);
            }
            while(!queue.isEmpty() && queue.peek().nextExecutionTime==currTime) {
                Pair currPairInQueue = queue.remove();
                pq.add(currPairInQueue);
            }
        }
        return currTime;




    }
}
