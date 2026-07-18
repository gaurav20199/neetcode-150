class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        return climbStairsRec(n,dp);
    }

    public int climbStairsRec(int n,int []dp) {
        if(n<0)
            return 0;
        if(n==0)
            return dp[n] = 1;

        if(dp[n]!=Integer.MIN_VALUE)
            return dp[n];    

        return dp[n] = climbStairsRec(n-1,dp)+climbStairsRec(n-2,dp);  
    }
}
