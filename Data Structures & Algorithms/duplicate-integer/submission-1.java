class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> intset = new HashSet<>();

        for(int num : nums){

            if(intset.contains(num)){

                return true;
            }

            intset.add(num);
        }

        return false;
        
    }
}