class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length; 
        for (int idx = 0; idx < nums.length; idx++) {
            xor ^= idx ^ nums[idx];
        }
        return xor;

    }
}
