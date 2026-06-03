class Solution {
    
    private int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public void solve(char[][] board) {

        //edge case

        if(board == null || board.length == 0)
        return ;

        int row = board.length, col = board[0].length;

        for(int i = 0; i < row; i++){

            dfs(board, row, col, i, 0);
            dfs(board, row, col, i, col- 1);
        }

        for(int i = 0; i < col; i++){

            dfs(board, row, col, 0, i);
            dfs(board, row, col, row - 1, i);
        }

        flipboard(board, row, col);

    }

    private void dfs(char[][] board, int row, int col, int i, int j){

        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] !='O') return ;

        board[i][j] = 'M';

        for(int[] dir : directions){

            int newrow = i + dir[0];
            int newcol = j + dir[1];

            dfs(board, row, col, newrow, newcol);
        }
    }

    private void flipboard(char[][] board, int row, int col){

        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){

                if(board[i][j] == 'M'){

                    board[i][j] = 'O';
                }

                else if(board[i][j] == 'O'){

                    board[i][j] = 'X';
                }
            }
        }
    }
}
