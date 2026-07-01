class Solution {
    public boolean checkValidString(String s) {

        int minopen = 0;
        int maxopen = 0;

        for(char ch : s.toCharArray()){

            if(ch == '('){

                minopen++;
                maxopen++;
            }

            else if(ch == ')'){

                minopen--;
                maxopen--;
            }

            else{

                maxopen++;
                minopen--;
            }

            if(maxopen < 0){

                return false;
            }

            minopen = Math.max(minopen, 0);
        }

        return minopen == 0;
        
    }
}
