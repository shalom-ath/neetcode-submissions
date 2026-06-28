class Solution {
    public boolean canJump(int[] nums) {

        int finl = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){

            if(i + nums[i] >= finl){

                finl = i;
            }
        }

        if(finl == 0){

                return true;
            }

        return false;
        
    }
}
