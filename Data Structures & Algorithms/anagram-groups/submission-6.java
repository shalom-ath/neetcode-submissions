class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> freqmap = new HashMap<>();

        for(String str : strs){

            String freqString = getfreqString(str);

            if(freqmap.containsKey(freqString)){

                freqmap.get(freqString).add(str);
            }

            else{

                List<String> strList = new ArrayList<>();
                strList.add(str);
                freqmap.put(freqString, strList);
            }
        }

        return new ArrayList<>(freqmap.values());
    }

    private String getfreqString(String str){

        int[] count = new int[26];

        for(char c : str.toCharArray()){

            count[c - 'a']++;
        }

        StringBuilder freqString = new StringBuilder("");

        char c = 'a';

        for(int i : count){

            freqString.append('a');
            freqString.append(i);
            c++;
        }

        return freqString.toString();
    }
}
