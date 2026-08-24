class Solution {
    public int missingNumber(int[] nums) {
        int expectedXor = 0;
        for(int idx=1;idx<=nums.length;idx++) {
            expectedXor^=idx;
        }
        int actualXor = nums[0];
        for(int idx=1;idx<nums.length;idx++) {
            actualXor^=nums[idx];
        }
        return expectedXor^actualXor;

    }
}
