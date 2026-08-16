class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedNums = new HashSet<>();
        while(n>1) {
            int sum = 0;
            while(n>0) {
                int digit = n % 10;
                sum+=digit*digit;
                n /= 10;
            }
            if(visitedNums.contains(sum))
                return false;
            
            visitedNums.add(sum);   
            n = sum;
        }
        return n==1?true:false;
    }
}
