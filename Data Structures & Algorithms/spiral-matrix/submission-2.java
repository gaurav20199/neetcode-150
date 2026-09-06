class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0)
            return res;
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        int top = 0;
        while(left<right && top<bottom) {
            // cover first row
            for(int idx=left;idx<right;idx++) {
                res.add(matrix[top][idx]);
            }
            top++;
            // cover last column
            for(int idx=top;idx<bottom;idx++) {
                res.add(matrix[idx][right-1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            // cover last row
            for(int idx=right-1;idx>=left;idx--) {
                res.add(matrix[bottom-1][idx]);
            }
            bottom--;
            // cover first column
            for(int idx=bottom-1;idx>=top;idx--) {
                res.add(matrix[idx][left]);
            }
            left++;
        }
        return res;        
        
    }
}
