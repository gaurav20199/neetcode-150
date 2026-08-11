class Solution {
    public void rotate(int[][] matrix) {
        reverseMatrix(matrix);
        for(int ridx=0;ridx<matrix.length;ridx++) {
            for(int cidx=ridx;cidx<matrix[0].length;cidx++) {
                int temp = matrix[ridx][cidx];
                matrix[ridx][cidx] = matrix[cidx][ridx];
                matrix[cidx][ridx] = temp;
            }
        }
    }

    public void reverseMatrix(int [][]matrix) {
        int n = matrix.length;
        for(int idx=0;idx<n/2;idx++) {
            int []subMatrix = matrix[idx];
            matrix[idx] = matrix[n-idx-1];
            matrix[n-idx-1] = subMatrix;
        }
    }
}
