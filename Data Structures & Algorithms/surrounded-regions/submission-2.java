class Solution {
    public void solve(char[][] board) {
       boolean [][]visited = new boolean[board.length][board[0].length]; 
       for(int idx=0;idx<board[0].length;idx++)
            if(!visited[0][idx] && board[0][idx]=='O')
                dfs(board,visited,0,idx);


        for(int idx=0;idx<board[0].length;idx++)
            if(!visited[board.length-1][idx] && board[board.length-1][idx]=='O')
                dfs(board,visited,board.length-1,idx);


        for(int idx=0;idx<board.length;idx++)
            if(!visited[idx][0] && board[idx][0]=='O')
                dfs(board,visited,idx,0);

        for(int idx=0;idx<board.length;idx++)
            if(!visited[idx][board[0].length-1] && board[idx][board[0].length-1]=='O')
                dfs(board,visited,idx,board[0].length-1);

        for(int ridx=0;ridx<board.length;ridx++) {
            for(int cidx=0;cidx<board[0].length;cidx++) {
                if(ridx==0 || cidx==0 || ridx==board.length-1 || cidx==board[0].length-1)
                    continue;
    
                if(board[ridx][cidx]=='V')
                    board[ridx][cidx]= 'O';
                else if(board[ridx][cidx]=='O')
                    board[ridx][cidx] = 'X';    

            }
        }                                   
    }

    private boolean boundaryHasO(int ridx, int cidx, int maxRowValue, int maxColValue, char value) {
        if((ridx==0 || ridx==maxRowValue || cidx==0 || cidx==maxColValue) && value=='O')
            return true;
        return false;    
    }

    private void dfs(char [][]board, boolean [][]visited, int ridx, int cidx) {
        if(ridx<0 || ridx>=board.length || cidx<0 || cidx>=board[0].length || visited[ridx][cidx] || board[ridx][cidx]=='X')
            return;

        visited[ridx][cidx] = true;
        //System.out.println("here");
        if(!boundaryHasO(ridx,cidx,board.length-1,board[0].length-1,'O'))
            board[ridx][cidx] = 'V';
        dfs(board,visited,ridx-1,cidx);
        dfs(board,visited,ridx+1,cidx);
        dfs(board,visited,ridx,cidx-1);
        dfs(board,visited,ridx,cidx+1);
    }
}
