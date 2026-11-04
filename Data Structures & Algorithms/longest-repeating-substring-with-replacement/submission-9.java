class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0, right = 0, maxfreq = 0, windowsize = 0;

        for(; right < s.length(); right++){

            freq[s.charAt(right) - 'A']++;

            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);

            int windowlength = right - left + 1;

            if(windowlength - maxfreq > k){

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowlength = right - left + 1;
            windowsize = Math.max(windowsize, windowlength);
        }

        return windowsize;
        
    }
}
