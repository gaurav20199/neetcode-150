class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        int maxLen = 0;
        for(int num:nums)
            visited.add(num);

        for(int num:visited) {
            int curLen = 1;
            if(!visited.contains(num-1)) {
                while(visited.contains(num+1)) {
                    curLen++;
                    num++;
                }
            }
            maxLen = Math.max(curLen,maxLen);
        }
        return maxLen;
    }
}
