class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int ridx=0;ridx<matrix.length;ridx++) {
            int start = 0;
            int end = matrix[0].length-1;
            while(start<=end) {
                int mid = start +(end-start)/2;
                if(matrix[ridx][mid]==target)
                    return true;
                else if(matrix[ridx][mid]<target)
                    start++;
                else
                    end--;        
            }
        }
        return false;
    }
}
