class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalZeroCount = 0;
        int []res = new int[nums.length];
        int productExcludingZero = 1;
        for(int num:nums) {
            if(num!=0)
                productExcludingZero*=num;
            else
                totalZeroCount++;
        }

        for(int idx=0;idx<nums.length;idx++) {
            if(nums[idx]==0) {
                res[idx] = totalZeroCount==1?productExcludingZero:0;
            }else {
                if(totalZeroCount==0)
                    res[idx] = productExcludingZero/nums[idx];
            }
        }



        return res;        
    }
}  
