class Solution {
    public int findKthLargest(int[] nums, int k) {
        //by using sorting

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
