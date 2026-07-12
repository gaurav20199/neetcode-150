class Solution {
    public int findDuplicate(int[] nums) {
        for(int idx=0;idx<nums.length;idx++) {
            int val = Math.abs(nums[idx]);
            if(nums[val-1]<0)
                return val;
            nums[val-1]*=-1;    
        }
        return -1;
    }
}
