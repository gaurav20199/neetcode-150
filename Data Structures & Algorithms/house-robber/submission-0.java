class Solution {
    public int rob(int[] nums) {
        int []mem = new int[nums.length];
        int []dp = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        return robUtil(nums,0,dp);
    }

    public int robUtil(int []nums, int idx,int []dp) {
        if(idx>=nums.length)
            return 0;
        if(dp[idx]!=Integer.MIN_VALUE)
            return dp[idx];    

        int pickedCurrentOne = nums[idx]+robUtil(nums,idx+2,dp);
        int notPickedCurrentOne = robUtil(nums,idx+1,dp);
        return dp[idx] = Math.max(pickedCurrentOne, notPickedCurrentOne);    
    }
}
