class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int idx = 0;
        int len = intervals.length;
        while(idx< len && intervals[idx][1]<newInterval[0]) {
            res.add(intervals[idx]);
            idx++;
        }

        while(idx<len && intervals[idx][0]<=newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0],intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[idx][1]);
            idx++;
        }
        res.add(newInterval);
        while(idx<len) {
            res.add(intervals[idx]);
            idx++;
        }
       
        return res.toArray(new int[res.size()][]);
    }
}
