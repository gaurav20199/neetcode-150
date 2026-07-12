class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []res = new int[nums.length];
        int []prefix = new int[nums.length];
        int []suffix = new int[nums.length];
        for(int idx=0;idx<nums.length;idx++)
            prefix[idx] = (idx==0?1:prefix[idx-1]*nums[idx-1]);

        for(int idx=nums.length-1;idx>=0;idx--)
            suffix[idx] = (idx==nums.length-1?1:suffix[idx+1]*nums[idx+1]);

        for(int idx=0;idx<nums.length;idx++) {
            res[idx] = prefix[idx]*suffix[idx];
        }
        return res;        
    }
}  
