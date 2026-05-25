class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //adding stones to queue

        for(int stone : stones){

            pq.add(stone);
        }

        while(pq.size() > 1){

            //x and y stones 

            int y = pq.poll();
            int x = pq.poll();

            if(x != y){

                pq.add(y - x);
            }

        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
