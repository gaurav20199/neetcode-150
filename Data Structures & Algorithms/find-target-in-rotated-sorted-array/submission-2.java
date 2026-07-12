class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            System.out.println(mid);
            if(nums[mid]>nums[end]) {
                start = mid+1;
            }else {
                end = mid;
            }
        }

        System.out.println(start);

        int ans = binarySearch(0,start-1,nums,target);
        if(ans!=-1)
            return ans;
        
        return binarySearch(start,nums.length-1,nums,target);
        
    }

    public int binarySearch(int start, int end, int[]nums, int target) {
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                end = mid-1;
            else
                start = mid+1;        
        }
        return -1;
    }
}
