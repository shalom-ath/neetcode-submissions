class Solution {
    public int maxSubArray(int[] nums) {

        int current = 0;
        int max = nums[0];

        for(int i = 0; i < nums.length; i++){

            if(current < 0){

                current = 0;
            }

            current = current + nums[i];
            max = Math.max(current, max);
        }

        return max;
        
    }
}
