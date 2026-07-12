class Solution {
    public int[] productExceptSelf(int[] nums) {
        int maxProduct = 1;
        int []res = new int[nums.length];
        int zeroCount = 0;

        for(int idx=0;idx<nums.length;idx++) {
            int num = nums[idx];
            if(num==0) {
                zeroCount++;
                continue;
            }
            maxProduct*=num;
        }
        if(zeroCount>1)
            return res;

        for(int idx=0;idx<nums.length;idx++) {
            if(zeroCount==1) {
                res[idx] = (nums[idx]==0)?maxProduct:0;
            }else {
                res[idx] = (nums[idx]==0)?maxProduct:maxProduct/nums[idx];
            }
        }
        return res;
    }
}  
