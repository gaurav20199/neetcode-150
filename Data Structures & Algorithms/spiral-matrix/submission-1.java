class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0)
            return res;
        boolean [][]elementsCovered = new boolean[matrix.length][matrix[0].length];
        int rowCounter = 0;
        int colCounter = 0;
        while(rowCounter<matrix.length || colCounter<matrix[0].length) {
            // cover first row
            for(int cidx=0;cidx<matrix[0].length && rowCounter<matrix.length;cidx++) {
                if(!elementsCovered[rowCounter][cidx]) {
                    elementsCovered[rowCounter][cidx] = true;
                    res.add(matrix[rowCounter][cidx]);
                }
            }
            
            int currLastColumn = matrix[0].length-1-colCounter;
            // cover last column
            for(int ridx=0;ridx<matrix.length && currLastColumn>=0;ridx++) {
                if(!elementsCovered[ridx][currLastColumn]) {
                    res.add(matrix[ridx][currLastColumn]);
                    elementsCovered[ridx][currLastColumn] = true;
                }
            }

            int currLastRow = matrix.length-1-rowCounter;
            // cover last row
            for(int cidx=matrix[0].length-1;cidx>=0 &&currLastRow>=0;cidx--) {
                if(!elementsCovered[currLastRow][cidx]) {
                    res.add(matrix[currLastRow][cidx]);
                    elementsCovered[currLastRow][cidx] = true;
                }
            }
            
            // cover first column
            for(int ridx=matrix.length-1;ridx>=0 && colCounter<matrix[0].length;ridx--) {
                if(!elementsCovered[ridx][colCounter]) {
                    res.add(matrix[ridx][colCounter]);
                    elementsCovered[ridx][colCounter] = true;
                }
            }
            rowCounter++;
            colCounter++;
        }
        return res;        
        
    }
}
