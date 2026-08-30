class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> visitedNums = new HashSet<>();
        for(int num:nums) {
            visitedNums.add(num);
        }
        int maxLen = 0;
        for(int num:nums) {
            int curLen = 1;
            if(!visitedNums.contains(num-1)) {
                while(visitedNums.contains(num+1)) {
                    curLen++;
                    num++;
                }
                maxLen = Math.max(maxLen,curLen);
            }
        }
        return maxLen;
    }
}
