class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> intSet = new HashSet<>();

        for(int num : nums){

            if(intSet.contains(num))

            return true;

            intSet.add(num);
        }

        return false;
        
    }
}