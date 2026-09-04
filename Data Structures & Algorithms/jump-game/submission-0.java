class Solution {
    public boolean canJump(int[] nums) {
        int destination = nums.length-1;
        for(int idx=nums.length-1;idx>=0;idx--) {
            if(idx+nums[idx]>=destination)
                destination = idx;
        }
        return destination==0;
    }
}
