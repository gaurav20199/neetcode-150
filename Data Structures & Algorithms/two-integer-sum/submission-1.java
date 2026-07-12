class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numToFreq = new HashMap<>();
        for(int idx=0;idx<nums.length;idx++) {
            numToFreq.put(nums[idx],idx);
        }
        for(int idx=0;idx<nums.length;idx++){
            int num = nums[idx];
            if(numToFreq.containsKey(target-num) && numToFreq.get(target-num)!=idx)
                return new int[]{idx,numToFreq.get(target-num)};
        }
        return new int[]{0};


        
    }
}
