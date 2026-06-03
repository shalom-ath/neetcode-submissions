class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        //edge case

        if(heights == null || heights.length == 0){

            return new ArrayList<>();
        }

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for(int i = 0; i < row; i++){

            dfs(i, 0, pacific, heights);
            dfs(i, col - 1, atlantic, heights);
        }        

        for(int j = 0; j < col; j++){

            dfs(0, j, pacific, heights);

            dfs(row - 1, j, atlantic, heights);
        }

        //result

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){

                if(pacific[i][j] && atlantic[i][j]){

                    result.add(List.of(i,j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] reachable, int[][] heights){

        int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

        reachable[row][col] = true;

        for(int[] dir : directions){

            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if(newrow < 0 || newrow >= heights.length || newcol < 0 || newcol >= heights[0].length){

                continue;
            }

            if(reachable[newrow][newcol])

            continue;

            if(heights[newrow][newcol] >= heights[row][col])

            dfs(newrow, newcol, reachable, heights);
        }
    }
}
