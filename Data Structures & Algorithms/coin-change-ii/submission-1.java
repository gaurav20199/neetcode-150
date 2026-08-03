class Solution {
    public int change(int amount, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        int [][]dp = new int[coins.length+1][amount+1];
        for(int []dpArr:dp)
            Arrays.fill(dpArr,-1);
        return coinChange(coins,amount,0,dp);
    }

    public int coinChange(int []candidates, int target, int idx, int [][]dp) {
        if(target==0) {
            return dp[idx][target] = 1;
        }
        if(target<0 || idx>=candidates.length)
            return 0;

        if(dp[idx][target]!=-1)
            return dp[idx][target];    
 
        int take = coinChange(candidates,target-candidates[idx],idx,dp);
        int notTake = coinChange(candidates,target,idx+1,dp);
        return dp[idx][target] = take+notTake;
        
    }
}
