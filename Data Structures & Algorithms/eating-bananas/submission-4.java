class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int minspeed = 1;
        int maxspeed = 0;

        for(int pile : piles){

            maxspeed = Math.max(maxspeed, pile);
        }

        while(minspeed < maxspeed){

            int speed = minspeed + (maxspeed - minspeed) / 2;

            if(eats(piles, h, speed)){

                maxspeed = speed;
            }

            else{

                minspeed = speed + 1;
            }
        }

        return minspeed;
        

    }

    private boolean eats(int[] piles, int h, int speed){

        int hours = 0;

        for(int pile : piles){

            hours += (int) Math.ceil((double) pile / speed);
        }

        return hours <= h;
    }
}
