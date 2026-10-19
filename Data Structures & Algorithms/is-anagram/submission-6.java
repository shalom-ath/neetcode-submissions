class Solution {
    public boolean isAnagram(String s, String t) {

        int[] countfreq = new int[26];

        for(int i = 0; i < s.length(); i++){

            countfreq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){

            countfreq[t.charAt(i) - 'a']--;
        }

       for(int count : countfreq){

            if(count != 0){

                return false;
            }
       }

       return true;

    }
}
