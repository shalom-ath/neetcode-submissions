class Solution {
    public String minWindow(String s, String t) {

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for(char ch : t.toCharArray()) mapT[ch]++;

        int left = 0, right = 0, minlength = Integer.MAX_VALUE, minstart = 0;

        for(; right < s.length(); right++){

            mapS[s.charAt(right)]++;

            while(contains(mapS, mapT)){

            if(right - left  + 1 < minlength){

                minlength = right - left + 1;
                minstart = left;
            }

            mapS[s.charAt(left++)]--;
        }

        }

        return minlength == Integer.MAX_VALUE ? "" : s.substring(minstart, minstart + minlength);
        
    }

    private boolean contains(int[] mapS, int[] mapT){

        for(int i = 0; i < 256; i++){

            if(mapS[i] < mapT[i]){

                return false;
            }


        }

        return true;
    }
}
