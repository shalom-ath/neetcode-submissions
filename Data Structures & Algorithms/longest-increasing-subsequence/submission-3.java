class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        for(int i = 1; i < nums.length; i++)
        
        for(int j = 0; j < i; j++)

        if(nums[i] > nums[j])

        if(dp[j] + 1 > dp[i])

        dp[i] = dp[j] + 1;

        int maxindex = 0;

        for(int i = 0; i < dp.length; i++){

            if(dp[i] > dp[maxindex])

            dp[maxindex] = dp[i];
        }

        return dp[maxindex] + 1;
    }
}
