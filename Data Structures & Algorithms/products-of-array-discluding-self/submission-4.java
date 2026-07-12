class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []res = new int[nums.length];
        for(int idx=0;idx<nums.length;idx++)
            res[idx] = idx==0?1:res[idx-1]*nums[idx-1];
        
        int mult = 1;
        for(int idx=nums.length-1;idx>=0;idx--) {
            res[idx]*=mult;
            mult*=nums[idx];
        }
        return res;        
    }
}  
