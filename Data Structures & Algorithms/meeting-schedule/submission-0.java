/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b) -> a.start-b.start);
        for(int idx=1;idx<intervals.size();idx++) {
            if(intervals.get(idx).start<intervals.get(idx-1).end)
                return false;
        }
        return true;
    }
}
