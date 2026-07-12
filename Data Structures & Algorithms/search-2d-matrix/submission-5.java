class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length*matrix[0].length-1;
        while(start<=end) {
            int mid = start+(end-start)/2;
            //System.out.println(start+","+mid+","+end);
            int ridx = mid/matrix[0].length;
            int cidx = mid%matrix[0].length;
            //System.out.println(ridx+","+cidx);

            //System.out.println("value:"+matrix[ridx][cidx]);
            if(matrix[ridx][cidx]==target)
                return true;
            else if(matrix[ridx][cidx]>target)
                end = mid-1;
            else
                start = mid+1;    
        }
        return false;
    }
}
