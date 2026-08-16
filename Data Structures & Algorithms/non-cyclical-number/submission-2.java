class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedNums = new HashSet<>();
        int slow = n;
        int fast = calculateSquare(n);
        while(slow!=fast) {
            slow = calculateSquare(slow);
            fast = calculateSquare(fast);
            fast = calculateSquare(fast);
        }
        return fast==1;
    }

    public int calculateSquare(int n) {
        int sum = 0;
        while(n>0) {
            int digit = n % 10;
            sum+=digit*digit;
            n /= 10;
        }
        return sum;
    }
}
