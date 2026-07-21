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

        //base cond

        if(intervals.size() == 0) return true;

        intervals.sort((a,b) -> a.start - b.start);

        for(int i = 0; i < intervals.size() - 1; i++){

            Interval meeting1 = intervals.get(i);
            Interval meeting2 = intervals.get(i + 1);

            if(meeting1.end > meeting2.start){

                return false;
            }
        }

        return true;

    }
}
