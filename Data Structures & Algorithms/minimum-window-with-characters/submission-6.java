class Solution {
    public String minWindow(String s, String t) {

        int[] smap = new int[256];
        int[] tmap = new int[256];

        for(char ch : t.toCharArray()) tmap[ch]++;

        int left = 0, right = 0, minlength = Integer.MAX_VALUE, minstart = 0;

        for(; right < s.length(); right++){

            smap[s.charAt(right)]++;

            while(contains(smap, tmap)){

                if(right - left < minlength){
                    
                    minlength = right - left + 1;
                    minstart = left;
                }

                smap[s.charAt(left++)]--;
            }
        }

        return minlength == Integer.MAX_VALUE ? "" : s.substring(minstart, minstart + minlength);
        
    }

    private boolean contains(int[] smap, int[] tmap){

        for(int i = 0; i < 256; i++){

            if(tmap[i] > smap[i]){

                return false;
            }
        }

        return true;
    }
}
