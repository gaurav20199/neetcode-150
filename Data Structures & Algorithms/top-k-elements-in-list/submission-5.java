class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numToFreq = new HashMap<>();
        for(int num:nums) {
            int initialFreq = numToFreq.getOrDefault(num,0);
            numToFreq.put(num,initialFreq+1);
        }

        List<Integer>[] countFreqToNum = new List[nums.length+1];
        for(Map.Entry<Integer,Integer> entry:numToFreq.entrySet()) {
            if(countFreqToNum[entry.getValue()]==null)
                countFreqToNum[entry.getValue()] =  new ArrayList<>();

            countFreqToNum[entry.getValue()].add(entry.getKey());
        }
        int []ans = new int[k];
        int count = 0;
        for(int idx=nums.length;idx>=0;idx--) {
            if(count==k)
                break;

            if(countFreqToNum[idx]!=null && !countFreqToNum[idx].isEmpty()) {
                for(int num:countFreqToNum[idx]) {
                    if(count==k)
                        break;
                    ans[count++] = num;
                }
            }    
        }
        return ans;


        
    }
}
