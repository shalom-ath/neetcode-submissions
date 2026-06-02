class Solution {
    public void islandsAndTreasure(int[][] grid) {

        //edge case

        if(grid == null || grid.length == 0 || grid[0].length == 0)
        return;

        int m = grid.length;
        int n = grid[0].length;
        int INF = Integer.MAX_VALUE;
        int[] DIRS = {0, 1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[i].length; j++){

                if(grid[i][j] == 0){

                    queue.offer(new int[]{i,j});
                }
            }
        }

        //BFS

        while(!queue.isEmpty()){
        int[] currentgate = queue.poll();

        int currentrow = currentgate[0];
        int currentcol = currentgate[1];

        //four directions

        for(int i = 0; i < 4; i++){

            int neighrow = currentrow + DIRS[i];
            int neighcol = currentcol + DIRS[i + 1];

            if(neighrow >= 0 && neighrow < m && neighcol >= 0 && neighcol < n && grid[neighrow][neighcol] == INF){

                grid[neighrow][neighcol] = grid[currentrow][currentcol] + 1; //updating dist

                queue.offer(new int[]{neighrow, neighcol});
            }
        }
        
    }
    }
}
