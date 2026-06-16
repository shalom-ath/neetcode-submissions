class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        backtrack(target, result, 0, new ArrayList<>(), candidates);

        return result;
    }

    private void backtrack(int target, List<List<Integer>> result, int start, List<Integer> current, int[] candidates){

        if(target == 0){

        result.add(new ArrayList<Integer>(current));

        return;

        }

        for(int i = start; i < candidates.length; i++){

            if(i > start && candidates[i] == candidates[i - 1]){

                continue;
            }

            if(target - candidates[i] < 0) 
            break;

            current.add(candidates[i]);

            backtrack(target - candidates[i], result, i + 1, current, candidates);

            current.remove(current.size() - 1);
        }
    }
}
