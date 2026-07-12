class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length==0)
            return false;

        Map<Integer,Integer> numToFreq = new HashMap<>();
        for(int num:nums) {
            numToFreq.merge(num, 1, Integer::sum);
        }
        
        return numToFreq.values().stream().filter(value -> value>1).count()>0;    
    }
}