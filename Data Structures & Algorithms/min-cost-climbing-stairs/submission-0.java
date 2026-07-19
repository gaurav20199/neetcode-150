class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int []mem = new int[cost.length];
        Arrays.fill(mem,Integer.MIN_VALUE);
        return Math.min(minCostClimbingStairsUtils(cost,0,mem),minCostClimbingStairsUtils(cost,1,mem));
    }

    public int minCostClimbingStairsUtils(int []cost, int idx,int []dp) {
        if (idx>=cost.length)
            return 0;

        if(dp[idx]!=Integer.MIN_VALUE)
            return dp[idx];    

        return dp[idx] = Math.min(minCostClimbingStairsUtils(cost,idx+1,dp),minCostClimbingStairsUtils(cost,idx+2,dp))+cost[idx];
    }
}
