class Solution {
    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<=end) {
            char startingChar = Character.toLowerCase(s.charAt(start));
            char endingChar = Character.toLowerCase(s.charAt(end));
            if(!Character.isLetterOrDigit(startingChar)) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(endingChar)) {
                end--;
                continue;
            }
            if(startingChar!=endingChar)
                return false;

            start++;
            end--;    
        }
        return true;
    }
}
