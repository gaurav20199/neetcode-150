class Solution {
    public int[] plusOne(int[] digits) {
        int idx = digits.length-1;
        List<Integer> ans = new LinkedList<>();
        int carry = 0;
        while(idx>=0) {
            int curDigit = digits[idx];
            int curSum = idx==digits.length-1?curDigit+carry+1:curDigit+carry;
            carry = curSum/10;
            int digitToAdd = curSum%10;
            ans.addFirst(digitToAdd);
            idx--;
        }
        if(carry!=0)
            ans.addFirst(carry);

        int []res = new int[ans.size()];
        idx = 0;
        for(int x:ans) {
            res[idx++] = x;
        }    
        return res;
    }
}
