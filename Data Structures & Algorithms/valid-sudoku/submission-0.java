class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check all rows
        for(int ridx=0;ridx<board.length;ridx++) {
            Set<Integer> numSeen = new HashSet<>();
            for(int cidx=0;cidx<board[0].length;cidx++) {
                if(board[ridx][cidx]=='.')
                    continue;
                int num = (int) board[ridx][cidx]-'0';
                if(numSeen.contains(num))
                    return false;
                                
                numSeen.add(num);    
    
            }
        }

        // check all columns
        for(int cidx=0;cidx<board[0].length;cidx++) {
            Set<Integer> numSeen = new HashSet<>();
            for(int ridx=0;ridx<board.length;ridx++) {
                if(board[ridx][cidx]=='.')
                    continue;
                int num = (int) board[ridx][cidx]-'0';
                if(numSeen.contains(num))
                    return false;
                
                numSeen.add(num);    
            }
        }

        // check 3*3 grid
        int miniGridRow = (int) Math.sqrt(board.length);
        int miniGridCol = (int) Math.sqrt(board[0].length);
        for(int ridx=0;ridx<board.length;ridx+=miniGridRow) {
            for(int cidx=0;cidx<board[0].length;cidx+=miniGridCol) {
                int rowRange = ridx+miniGridRow;
                int colRange = cidx+miniGridCol;
                Set<Integer> numSeen = new HashSet<>();

                for(int kridx=ridx;kridx<rowRange;kridx++) {
                    for(int kcidx=cidx;kcidx<colRange;kcidx++) {
                        if(board[kridx][kcidx]=='.')
                            continue;
                        int val = (int) board[kridx][kcidx]-'0';
                        if(numSeen.contains(val))
                            return false;

                        numSeen.add(val);    
                    }
                }
            }
        }

        return true;


    }
}
