class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int idx=0;idx<nums.length;idx++) {
            int val = nums[idx];
            if(curSum+val>=val)
                curSum+=val;
            else
                curSum=val;
            maxSum = Math.max(maxSum,curSum);        
        }
        return maxSum;

    }
}
