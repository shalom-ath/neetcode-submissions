class Solution {
    public int lengthOfLIS(int[] nums) {

        TreeSet<Integer> bst = new TreeSet<>();

        for(int num : nums){

            Integer higherequal = bst.ceiling(num);

            if(higherequal == null) 

            bst.add(num);

            else

            bst.remove(higherequal);

            bst.add(num);
        }

        return bst.size();
        
    }
}
