class Solution {
    public int longestConsecutive(int[] nums) {

        int longestlength = 0;

        Map<Integer, Boolean> exploredmap = new HashMap<>();


        for(int num : nums){

            exploredmap.put(num, Boolean.FALSE);
        }

        for(int num : nums){

            int currentlength = 1;

            //forward

            int nextnum = num + 1;

            while(exploredmap.containsKey(nextnum) && exploredmap.get(nextnum) == false){

                currentlength++;

                exploredmap.put(num, Boolean.TRUE);

                nextnum++;
            }

            //backwards

            int prevnum = num - 1;

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
