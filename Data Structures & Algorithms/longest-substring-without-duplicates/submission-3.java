class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        while(start<=end && end<s.length()) {
            char endCharacter = s.charAt(end);
            int freq = charToFreq.getOrDefault(endCharacter,0)+1;
            charToFreq.put(endCharacter,freq);
            //System.out.println(endCharacter+","+freq);
            while(charToFreq.getOrDefault(endCharacter,0)>1) {
                maxLength = Math.max(maxLength,end-start);
                char startingCharacter = s.charAt(start);
                int startingCharFreq = charToFreq.getOrDefault(startingCharacter,0)-1;
                if(startingCharFreq==0)
                    charToFreq.remove(startingCharacter);
                else
                    charToFreq.put(startingCharacter,startingCharFreq);  
                start++;    
            }
            end++;
        }
        maxLength = Math.max(maxLength,end-start);
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}
