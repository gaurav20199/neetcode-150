class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<Long> uniqueNumbers = new HashSet<>();
        for(int fidx=0;fidx<nums.length;fidx++) {
            int sidx = fidx+1;
            int tidx = nums.length-1;
            while(sidx<tidx) {
                if(nums[fidx]+nums[sidx]+nums[tidx]==0) {
                    long code = formUniqueCode(nums[fidx],nums[sidx],nums[tidx]);
                    System.out.println(code);
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

    public long formUniqueCode(int num1, int num2, int num3) {
        System.out.println(num1+","+num2+","+num3);
        long csum = num1*100000;
        csum+=num2;
        csum*=100000;
        csum+=num3;
        csum*=100000;
        return csum;
    }
}
