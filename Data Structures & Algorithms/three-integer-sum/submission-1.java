class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int idx=0;idx<nums.length;idx++) {
            for(int idx2=idx+1;idx2<nums.length;idx2++) {
                for(int idx3=idx2+1;idx3<nums.length;idx3++) {
                    if((nums[idx]+nums[idx2]+nums[idx3]==0)) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[idx]);
                        res.add(nums[idx2]);
                        res.add(nums[idx3]);
                        ans.add(res);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
