class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedNums = new HashSet<>();
        while(n>1) {
            String number = String.valueOf(n);
            int sum = 0;
            for(int idx=0;idx<number.length();idx++) {
                int digit = (int) (number.charAt(idx)-'0');
                sum+=(digit*digit);
            }
            if(visitedNums.contains(sum))
                return false;
            
            visitedNums.add(sum);   
            n = sum;
        }
        return n==1?true:false;
    }
}
