class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int lastEncounteredEnd = intervals[0][1];
        int count = 0;
        for(int idx=1;idx<intervals.length;idx++) {
            int start = intervals[idx][0];
            int end = intervals[idx][1];
            if(lastEncounteredEnd>start)
                count++;
            else    
                lastEncounteredEnd = end;
        }
        return count;
    }
}
