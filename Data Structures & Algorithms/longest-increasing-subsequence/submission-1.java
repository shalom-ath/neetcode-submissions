class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();

        for(int num : nums){

            Integer higherval = bst.ceiling(num);

            if(higherval == null)

            bst.add(num);

            else

            bst.remove(higherval);

            bst.add(num);
        }

        return bst.size();
    }


    
}
