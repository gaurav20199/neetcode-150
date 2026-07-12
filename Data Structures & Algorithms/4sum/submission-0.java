class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> unique = new HashSet<>();
        for(int fidx=0;fidx<nums.length-3;fidx++) {
            for(int sidx=fidx+1;sidx<nums.length-2;sidx++) {
                int tidx = sidx+1;
                int fourthidx = nums.length-1;
                while(tidx<fourthidx) {
                    long sum = nums[fidx];
                    sum+=nums[sidx];
                    sum+=nums[tidx];
                    sum+=nums[fourthidx];
                    if(sum==target) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(nums[fidx]);
                        sb.append(nums[sidx]);
                        sb.append(nums[tidx]);
                        sb.append(nums[fourthidx]);
                        if(!unique.contains(sb.toString())) {
                            res.add(Arrays.asList(nums[fidx],nums[sidx],nums[tidx],nums[fourthidx]));
                            unique.add(sb.toString());
                        }
                        tidx++;
                        fourthidx--;
                    }else if(sum>target) {
                        fourthidx--;
                    }else {
                        tidx++;
                    }
                }
            }
        }
        return res;
    }
}