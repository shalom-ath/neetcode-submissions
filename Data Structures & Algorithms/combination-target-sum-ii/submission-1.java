class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        backtrack(target, result, candidates, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int target, List<List<Integer>> result, int[] candidates, int start, List<Integer> current){

        if(target == 0){

            result.add(new ArrayList<Integer>(current));

            return;
        }

        for(int i = start; i < candidates.length; i++){

            if(i > start && candidates[i] == candidates[i - 1]){

                continue;
            }

            if(target - candidates[i] < 0){

                break;
            }

            current.add(candidates[i]);

            backtrack(target - candidates[i], result, candidates, i + 1, current);

            current.remove(current.size() - 1);
        }
    }
}
