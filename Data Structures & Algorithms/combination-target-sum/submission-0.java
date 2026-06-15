class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> combo = new ArrayList<>();

        backtrack(target, result, combo, 0, nums);

        return result;
        
    }

    private void backtrack(int target, List<List<Integer>> result, List<Integer> combo, int start, int[] nums){

        if(target == 0)

        result.add(new ArrayList<Integer>(combo));

        else if(target < 0) return;

        for(int i = start; i < nums.length; i++){

            combo.add(nums[i]);

            backtrack(target - nums[i], result, combo, i, nums);

            combo.remove(combo.size() - 1);


        }
    }
}
