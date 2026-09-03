class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check all rows
        int subGridSize = (int) Math.sqrt(board.length);
        boolean [][]rowToNum = new boolean[board.length][board.length];
        boolean [][]colToNum = new boolean[board.length][board.length];
        boolean [][]subGridToNum = new boolean[board.length][board.length];
        for(int ridx=0;ridx<board.length;ridx++) {
            for(int cidx=0;cidx<board[0].length;cidx++) {
                if(board[ridx][cidx]=='.')
                    continue;
                int num = (int) board[ridx][cidx]-'1';
                int boxIdx = (ridx / subGridSize) * subGridSize + (cidx / subGridSize);
                if(rowToNum[ridx][num] || colToNum[cidx][num] || subGridToNum[boxIdx][num])
                    return false;

                subGridToNum[boxIdx][num] = true;
                rowToNum[ridx][num] = true;
                colToNum[cidx][num] = true;
            }
        }

        return true;
    }
}
