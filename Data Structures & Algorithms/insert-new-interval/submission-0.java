class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        //result list

        List<int[]> result = new ArrayList<>();

        int i = 0, n = intervals.length;

        //adding the intervals which dont overlap

        while(i < n && intervals[i][1] < newInterval[0]){

            result.add(intervals[i++]);
        }

        //merging newintervals w the intervals

        while(i < n && intervals[i][0] <= newInterval[1]){

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        //add the remaining intervals

        while(i < n){

            result.add(intervals[i++]);
        }


        return result.toArray(new int[result.size()][]);
    }
}
