class Solution {
    public int jump(int[] nums) {

        int jump = 0, currentmax = 0, currentend = 0;

        for(int i = 0; i < nums.length - 1; i++){

            currentmax = Math.max(currentmax, i + nums[i]);

            if(i == currentend){

                jump++;
                currentend = currentmax;
            }
        } 

        return jump;
        
    }
}
