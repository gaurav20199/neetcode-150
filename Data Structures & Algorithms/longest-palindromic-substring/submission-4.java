class Solution {
    class Pair {
        int maxLength;
        String longestSubstring;

        public Pair(int len, String str) {
            this.maxLength = len;
            this.longestSubstring = str;
        }
    }

    public String longestPalindrome(String s) {
        Pair [][]dp = new Pair[s.length()+1][s.length()+1];
        // for(Pair []dpArr:dp) {
        //     Arrays.fill(dpArr, new Pair(Integer.MIN_VALUE,""));
        // }
        return longestPalindromicSubstring(s,0,s.length()-1,dp).longestSubstring;
    }

    public Pair createPair(int len, String str) {
        return new Pair(len, str);
    }

    public boolean isPalindrome(String str, int start, int end) {
        while(start<end) {
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;    
        }
        return true;
    }

    public Pair longestPalindromicSubstring(String s, int startingIdx, int endingIdx,Pair [][]dp) {
        if(startingIdx>=s.length() || endingIdx<0 || startingIdx>endingIdx)
            return new Pair(0,"");

        if(startingIdx==endingIdx)
            return dp[startingIdx][endingIdx]=createPair(1,""+s.charAt(startingIdx));

        if(dp[startingIdx][endingIdx]!=null)
            return dp[startingIdx][endingIdx];

        // if(isPalindrome(s,startingIdx,endingIdx))
        //     return dp[startingIdx][endingIdx] = new Pair(endingIdx-startingIdx+1,s.substring(startingIdx,endingIdx+1));    

        Pair pairWithoutStartingChar = longestPalindromicSubstring(s,startingIdx+1,endingIdx,dp);
        Pair pairWithoutEndingChar = longestPalindromicSubstring(s,startingIdx,endingIdx-1,dp);
        Pair pairWithoutStartingAndEndingChar = longestPalindromicSubstring(s,startingIdx+1,endingIdx-1,dp);

        boolean isCharEqual = s.charAt(startingIdx) == s.charAt(endingIdx);        
        int innerLength = endingIdx - startingIdx - 1;
        
        // If outer characters match AND the middle substring is a palindrome, the whole window is a palindrome
        if (isCharEqual && pairWithoutStartingAndEndingChar.maxLength == innerLength)
            return dp[startingIdx][endingIdx] = new Pair(endingIdx-startingIdx+1, s.substring(startingIdx,endingIdx+1));    
        

        return dp[startingIdx][endingIdx]=pairWithoutStartingChar.maxLength>=pairWithoutEndingChar.maxLength?(pairWithoutStartingChar.maxLength>=pairWithoutStartingAndEndingChar.maxLength)?pairWithoutStartingChar:pairWithoutStartingAndEndingChar:(pairWithoutEndingChar.maxLength>=pairWithoutStartingAndEndingChar.maxLength)?pairWithoutEndingChar:pairWithoutStartingAndEndingChar;      
       
       
    }
}
