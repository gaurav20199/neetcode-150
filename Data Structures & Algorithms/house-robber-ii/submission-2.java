class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int []mem = new int[nums.length];
        int []mem2 = new int[nums.length];
        Arrays.fill(mem,Integer.MIN_VALUE);
        Arrays.fill(mem2,Integer.MIN_VALUE);
        return Math.max(robUtil(nums,0,nums.length-2,mem),robUtil(nums,1,nums.length-1,mem2));
    }

    public int robUtil(int []nums, int idx, int end, int []dp) {
        if(idx>end)
            return 0;

        if(dp[idx]!=Integer.MIN_VALUE)
            return dp[idx];    

        int take =nums[idx]+robUtil(nums,idx+2,end,dp);
        int notTake = robUtil(nums,idx+1,end,dp);
        return dp[idx] = Math.max(take,notTake);   
    }
}
