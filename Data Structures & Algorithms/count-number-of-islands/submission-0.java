class Solution {
    public int numIslands(char[][] grid) {

        //edge case

        if(grid == null || grid.length == 0 || grid[0].length == 0){

            return 0;
        }

        int island = 0;

        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[i].length; j++){

                if(grid[i][j] == '1'){

                    dfs(grid, i, j);

                    island++;
                }
            }
        }

        return island;
        
    }

    public void dfs(char[][] grid, int i, int j){

        //edge case

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){

            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
