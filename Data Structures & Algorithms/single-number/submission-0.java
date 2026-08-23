class Solution {
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for(int idx=1;idx<nums.length;idx++) {
            num^=nums[idx];
        }
        return num;
    }
}
