class TimeMap {

    Map<String,Map<Integer,String>> keyWithValue;
    Map<String,List<Integer>> keyWithTimestamp; 

    public TimeMap() {
        keyWithValue = new HashMap<>();
        keyWithTimestamp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyWithValue.computeIfAbsent(key,k -> new HashMap()).put(timestamp,value);
        keyWithTimestamp.computeIfAbsent(key, k -> new ArrayList()).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(keyWithTimestamp.containsKey(key)) {
            List<Integer> timestamps = keyWithTimestamp.get(key);
            int timestampCandidate = binarySearch(timestamps,timestamp);
            return timestampCandidate==-1?"":keyWithValue.get(key).get(timestampCandidate);
        }
        return "";
    }

    public int binarySearch(List<Integer> timestamps, int timestampToSearch) {
    if (timestamps == null || timestamps.isEmpty()) return -1;
    
    int start = 0;
    int end = timestamps.size();

    while (start < end) {
        int mid = start + (end - start) / 2;
        if (timestamps.get(mid) <= timestampToSearch)
            start = mid + 1;
        else 
            end = mid;
    }

    int floorIndex = start - 1;

    if (floorIndex >= 0 && floorIndex < timestamps.size())
        return timestamps.get(floorIndex); 
    
    return -1; 
}


  


    // public String binarySearch(List<Integer> timestamps,int timestampToSearch) {
    //     if(timestamps.isEmpty())
    //         return "";
    //     System.out.println(timestamps);
    //     int start = 0;
    //     int end = timestamps.size()-1;
    //     while(start<=end) {
    //         int mid = start+(end-start)/2;
    //         if (timestamps.get(mid) <= timestampToSearch) {
    //             start = mid + 1;
    //         } else {
    //             end = mid;
    //         }
              
    //     }
    //      int floorIndex = start - 1;

    //     if (floorIndex >= 0) {
    //         return String.valueOf(timestamps.get(floorIndex));
    //     }
    //     return "";
    // }
}
