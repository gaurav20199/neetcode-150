class MedianFinder {

    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        if(list.size()==0)
            return 0.0;
        Collections.sort(list);
        int size = list.size();
        //System.out.println(size);
        double middleElement = (double) list.get(size/2);
        // System.out.println(size/2+","+list.get(1));
        // System.out.println(size+","+middleElement);
        return (size%2==0)?(middleElement+list.get(size/2-1))/2:middleElement;      
    }
}
