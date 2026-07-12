class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int fidx=0;fidx<nums.length;fidx++) {
            int sidx = fidx+1;
            int tidx = nums.length-1;
            if(fidx>0 && nums[fidx]==nums[fidx-1])
                continue;

            while(sidx<tidx) {
                if(nums[fidx]+nums[sidx]+nums[tidx]==0) {
                    res.add(Arrays.asList(nums[fidx],nums[sidx],nums[tidx]));
                    sidx++;
                    tidx--;
                    while(sidx<tidx && nums[sidx]==nums[sidx-1])
                        sidx++;
                }else if(nums[fidx]+nums[sidx]+nums[tidx]>0) {
                    tidx--;
                }else if(nums[fidx]+nums[sidx]+nums[tidx]<0) {
                    sidx++;
                }
            }
        }
        return res;
    }
}
