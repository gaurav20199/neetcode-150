class Solution {
        public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        int val = minCoinChange(coins, amount, 0, dp);
        return val == (int)1e9 ? -1 : val;
    }

    public int minCoinChange(int[] coins, int amount, int idx, Integer[][] dp) {
        if (amount == 0)
            return 0;
            
        if (idx >= coins.length)
            return (int)1e9; 

        if (dp[idx][amount] != null)
            return dp[idx][amount];

        int includeCoin = (int)1e9;
        if (amount >= coins[idx]) {
            int subProblem = minCoinChange(coins, amount - coins[idx], idx, dp);
            if (subProblem != (int)1e9) {
                includeCoin = 1 + subProblem;
            }
        }
        
        int excludeCoin = minCoinChange(coins, amount, idx + 1, dp);
        return dp[idx][amount] = Math.min(includeCoin, excludeCoin);    
    }

}
