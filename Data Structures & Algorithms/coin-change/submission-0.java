class Solution {
        public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        int maxPlaceholder = amount + 1;
        int result = minCoinsHelper(amount, coins, dp, maxPlaceholder);
        return result == maxPlaceholder ? -1 : result;
    }

    private int minCoinsHelper(int remainingAmount, int[] coins, Integer[] dp, int maxPlaceholder) {
        if (remainingAmount == 0) return 0;
        if (remainingAmount < 0) return maxPlaceholder;
        if (dp[remainingAmount] != null) return dp[remainingAmount];
        int minCoinsNeeded = maxPlaceholder;
        for (int coin : coins) {
            if (remainingAmount - coin >= 0) {
                int subProblem = minCoinsHelper(remainingAmount - coin, coins, dp, maxPlaceholder);
                minCoinsNeeded = Math.min(minCoinsNeeded, 1 + subProblem);
            }
        }
        return dp[remainingAmount] = minCoinsNeeded;
    }

}
