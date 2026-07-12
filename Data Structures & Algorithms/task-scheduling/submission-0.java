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
          for(int idx=0;idx<tasks.length;idx++) {
                char ch = tasks[idx];
                freqArr[ch-'A']++;
          }
          PriorityQueue<Pair> pq = new PriorityQueue<>();
          for(int freqValue:freqArr) {
                if(freqValue!=0)
                    pq.add(new Pair(freqValue,0));
          }
          int timeTaken = 0;
          Queue<Pair> queue = new LinkedList<>();
          while(!pq.isEmpty() || !queue.isEmpty()) {
                timeTaken++;
                if(!pq.isEmpty()) {
                    Pair removedPair = pq.remove();
                    removedPair.freq--;
                    removedPair.nextExecutionTime = timeTaken+n;
                    if(removedPair.freq>0)
                        queue.add(removedPair);
                }

                while(queue.size()>0 && queue.peek().nextExecutionTime==timeTaken) {
                    Pair removedPair = queue.remove();
                    pq.add(removedPair);
                }
          }
          return timeTaken;



    }
}
