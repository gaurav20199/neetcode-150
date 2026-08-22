class Solution {
    public void sortColors(int[] nums) {
        int firstPtr = 0;
        int workerPtr = 0;
        int thirdPtr = nums.length-1;
        while(workerPtr<=thirdPtr) {
            if(nums[workerPtr]==0) {
                swap(nums,firstPtr,workerPtr);
                firstPtr++;
                workerPtr++;
            }else if(nums[workerPtr]==1) {
                workerPtr++;
            }else {
                swap(nums,thirdPtr,workerPtr);
                thirdPtr--;
            }
        }
    }

    public void swap(int []nums, int idx, int workerPtrIdx) {
        int temp = nums[idx];
        nums[idx] = nums[workerPtrIdx];
        nums[workerPtrIdx] = temp;
    }
}