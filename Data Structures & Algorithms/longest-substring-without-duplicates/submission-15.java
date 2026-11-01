class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charset = new HashSet<>();

        int left = 0, right = 0, maxlength = 0;

        for(; right < s.length(); right++){

            while(charset.contains(s.charAt(right))){

                charset.remove(s.charAt(left++));
            }

            charset.add(s.charAt(right));
            maxlength = Math.max(maxlength, right - left + 1);
        }

        return maxlength;
        
    }
}
