class Solution {
    public int longestConsecutive(int[] nums) {

        int longestlength = 0;

        Map<Integer, Boolean> exploredmap = new HashMap<>();

        for(int n : nums){

            exploredmap.put(n, Boolean.FALSE);
        }

        for(int n : nums){

            int currentlength = 1;

            int nextnum = n + 1;

            while(exploredmap.containsKey(nextnum) && exploredmap.get(nextnum) == false){

                currentlength++;

                exploredmap.put(nextnum, Boolean.TRUE);
                nextnum++;

            }

            int prevnum = n - 1;

            while(exploredmap.containsKey(prevnum) && !exploredmap.get(prevnum)){
                
                currentlength++;

                exploredmap.put(prevnum, Boolean.TRUE);
                prevnum--;
            }

            longestlength = Math.max(longestlength, currentlength);
        }

        return longestlength;
        
    }
}
