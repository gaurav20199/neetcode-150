class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stoneVal:stones)
            pq.offer(stoneVal);

        while(!pq.isEmpty()) {
            int currWeight = pq.remove();
            if(pq.isEmpty())
                return currWeight;
            int nextWeight = pq.remove();
            pq.offer(currWeight-nextWeight);
        }
        return -1;   
    }
}
