class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        for(;end<s.length();end++) {
            char endCharacter = s.charAt(end);
            if(charToFreq.containsKey(endCharacter))
                start = Math.max(charToFreq.get(endCharacter)+1,start); 

            maxLength = Math.max(maxLength,end-start+1);
            charToFreq.put(endCharacter,end);
        }
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}
