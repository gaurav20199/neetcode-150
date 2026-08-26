class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        String binaryStr = Integer.toBinaryString(n);
        for(char ch:binaryStr.toCharArray()) {
            if(ch=='1')
                ans++;
        }
        return ans;
    }
}
