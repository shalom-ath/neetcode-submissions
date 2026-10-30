class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //edge case

        if(s1.length() > s2.length() || s2.length() == 0) return false;

        if(s1.length() == 0) return true;

        int x = s1.length();

        int y = s2.length();

        int[] arrx = new int[26];
        int[] arry = new int[26];

        for(int i = 0; i < x; i++){

            arrx[s1.charAt(i) - 'a']++;
            arry[s2.charAt(i) - 'a']++;
        }

        for(int i = x; i < y; i++){

            if(Arrays.equals(arrx, arry)){

                return true;
            }

            arry[s2.charAt(i - x) - 'a']--;
            arry[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(arrx, arry)) return true;

        else return false;
        
    }
}
