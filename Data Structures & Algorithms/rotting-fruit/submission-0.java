class Solution {
    public int orangesRotting(int[][] grid) {

        //edge case

        if(grid == null || grid.length == 0) return -1;

        int row = grid.length;
        int col = grid[0].length;

        int[][] time = new int[row][col];

        for(int i = 0; i < row ; i++){

            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < row; i++)

            for(int j = 0; j < col; j++)

            if(grid[i][j] == 2)

            dfs(grid, i, j, time, 0);

            int timereq = 0;

            for(int i = 0; i < row; i++)

            for(int j = 0; j < col; j++)

            if(grid[i][j] == 1){

                if(time[i][j] == Integer.MAX_VALUE) return -1;

                timereq = Math.max(timereq, time[i][j]);
            }

            return timereq;
    }

    private void dfs(int[][] grid, int i, int j, int[][] time, int currenttime){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || currenttime >= time[i][j]) return;

        time[i][j] = currenttime;

        dfs(grid, i + 1, j , time, currenttime + 1);
        dfs(grid, i - 1, j, time, currenttime + 1);
        dfs(grid, i , j + 1, time, currenttime + 1);
        dfs(grid, i, j - 1, time, currenttime + 1);
    }
}
