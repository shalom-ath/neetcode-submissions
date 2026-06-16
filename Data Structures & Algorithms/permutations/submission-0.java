class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> tempList = new ArrayList<>();

        backtrack(result, tempList, nums);
        
        return result;
        
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums){

        if(tempList.size() == nums.length){

        result.add(new ArrayList<Integer>(tempList));
        return;

        }

        for(int num : nums){

           if(tempList.contains(num))

            continue;

            tempList.add(num);

            backtrack(result, tempList, nums);

            tempList.remove(tempList.size() - 1);
        }
    }
}
