class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numToFreq = new TreeMap<>((a, b) -> b-a);
        for(int num:nums) {
            int initialFreq = numToFreq.getOrDefault(num,0);
            numToFreq.put(num,initialFreq+1);
        }
        List<int []> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            list.add(new int[]{entry.getValue(),entry.getKey()});
        }
        list.sort((a,b) -> b[0]-a[0]);
        int count = 0;
        int []ans = new int[k];
        for(int []keyValueInfo:list) {
            if(count==k)
                break;
            ans[count++] = keyValueInfo[1];
        }
        return ans;
    }
}
