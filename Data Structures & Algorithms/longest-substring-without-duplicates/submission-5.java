class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        for(;end<s.length();end++) {
            char endCharacter = s.charAt(end);
            while(charToFreq.containsKey(endCharacter)) {
                maxLength = Math.max(maxLength,end-start);
                start = Math.max(charToFreq.get(endCharacter)+1,start); 
                charToFreq.remove(endCharacter);   
            }
            charToFreq.put(endCharacter,end);
        }
        maxLength = Math.max(maxLength,end-start);
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}
