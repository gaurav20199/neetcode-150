class Solution {
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (condition(arr,mid,high)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        if (low < arr.length && condition(arr,low,high)) return arr[low];
        return -1;
    }

    public boolean condition(int []arr, int mid,int high) {
        int rightBoundaryIndex = (high == arr.length) ? arr.length - 1 : high;
        if(mid<arr.length && arr[mid]<=arr[rightBoundaryIndex])
            return true;

        return false;    
    }

    
}
