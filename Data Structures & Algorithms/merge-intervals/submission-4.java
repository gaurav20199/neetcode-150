class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null)
            return new int[0][0];

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> res = new ArrayList<>();
        int lastEndingInterval = intervals[0][1];
        int lastStartingInterval = intervals[0][0];
        for(int idx=1;idx<intervals.length;idx++) {
            int []currInterval = intervals[idx];
            int starting = currInterval[0];
            int ending = currInterval[1];
            if(lastEndingInterval>=starting && lastEndingInterval<=ending) {
                lastEndingInterval = ending;
            }else if(lastEndingInterval>=ending) {
                continue;
            }
            else {
                res.add(Arrays.asList(lastStartingInterval,lastEndingInterval));
                lastStartingInterval= starting;
                lastEndingInterval = ending;
            }
        }
        if(!res.isEmpty()) {
            List<Integer> lastInterval = res.get(res.size()-1);                
            if((lastInterval.get(0)!=lastStartingInterval || lastInterval.get(1)!=lastEndingInterval) && lastInterval.get(1)<lastEndingInterval)
                res.add(Arrays.asList(lastStartingInterval,lastEndingInterval));
            
        }else {
            res.add(Arrays.asList(lastStartingInterval,lastEndingInterval));

        }
        int [][]ans = new int[res.size()][2];
        int idx=0;
        for(List<Integer> list:res) {
            ans[idx][0]=list.get(0);
            ans[idx][1] = list.get(1);
            idx++;
        }
        return ans;
    }

    // [1,1] [1,2] [1,3] [1,4] [1,5] [3,8]
}
