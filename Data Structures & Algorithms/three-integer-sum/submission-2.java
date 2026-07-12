class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> uniqueNumbers = new HashSet<>();
        for(int fidx=0;fidx<nums.length;fidx++) {
            int sidx = fidx+1;
            int tidx = nums.length-1;
            while(sidx<tidx) {
                if(nums[fidx]+nums[sidx]+nums[tidx]==0) {
                    String code = formUniqueCode(nums[fidx],nums[sidx],nums[tidx]);
                    if(!uniqueNumbers.contains(code)) {
                        res.add(Arrays.asList(nums[fidx],nums[sidx],nums[tidx]));
                        uniqueNumbers.add(code);
                    }
                    sidx++;
                    tidx--;
                }else if(nums[fidx]+nums[sidx]+nums[tidx]>0) {
                    tidx--;
                }else if(nums[fidx]+nums[sidx]+nums[tidx]<0) {
                    sidx++;
                }
            }
        }
        return res;
    }

    public String formUniqueCode(int num1, int num2, int num3) {
        return num1+"|"+num2+"|"+num3;
    }
}
