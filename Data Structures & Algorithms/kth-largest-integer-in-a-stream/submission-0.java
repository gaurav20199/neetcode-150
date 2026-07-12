class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int kthNumberToFind;

    public KthLargest(int k, int[] nums) {
        this.kthNumberToFind = k;
        for(int num:nums) {
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }
        System.out.println(pq);
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>kthNumberToFind)
            pq.remove();
        return pq.peek();
    }
}
