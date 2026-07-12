class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numToFreq = new HashMap<>();
        for(int num:nums) {
            int initialFreq = numToFreq.getOrDefault(num,0);
            numToFreq.put(num,initialFreq+1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry:numToFreq.entrySet()) {
            heap.offer(new int[]{entry.getValue(),entry.getKey()});
        }
        int heapSize = heap.size();
        while(heapSize>k) {
            heap.poll();
            heapSize--;
        }
        int []ans = new int[k];
        int count = 0;
        while(!heap.isEmpty()) {
            ans[count++] = heap.poll()[1];
        }
        return ans;

        
    }
}
