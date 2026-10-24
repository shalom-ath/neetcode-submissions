class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int prodbeforecurrent = 1;
        int prodaftercurrent = 1;

        for(int i = 0; i < n; i++){

            result[i] = prodbeforecurrent;
            prodbeforecurrent *= nums[i];
        }

        for(int i = n - 1; i >= 0; i--){

            result[i] *= prodaftercurrent;
            prodaftercurrent *= nums[i];
        }

        return result;
        
    }
}  
