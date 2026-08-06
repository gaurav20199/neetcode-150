class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> characterToFreq = new HashMap<>();
        int start = 0;
        int longestSubString = 0;
        for(int end=0;end<s.length();end++) {
            char endingChar = s.charAt(end);
            characterToFreq.put(endingChar,characterToFreq.getOrDefault(endingChar,0)+1);
            while(characterToFreq.getOrDefault(endingChar,0)>1) {
                char startingChar = s.charAt(start);
                longestSubString = Math.max(longestSubString,end-start);
                int newFreq = characterToFreq.get(startingChar)-1;
                start++;
                if(newFreq==0)
                    characterToFreq.remove(startingChar);
                else
                    characterToFreq.put(startingChar,newFreq);    
            }
        }
        longestSubString = Math.max(longestSubString,s.length()-start);
        return longestSubString;
    }
}
