class Solution {
    public int findDuplicate(int[] nums) {
        for(int idx=0;idx<nums.length;idx++) {
            int transFormedIndex = Math.abs(nums[idx])-1;
            if(nums[transFormedIndex]<0)
                return Math.abs(nums[idx]);
            nums[transFormedIndex]*=-1;
            //System.out.println(idx+","+transFormedIndex+","+nums[transFormedIndex]);

        }
        return -1;
    }
}
