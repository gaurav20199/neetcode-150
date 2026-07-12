class Solution {
    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<=end) {
            char startingChar = Character.toLowerCase(s.charAt(start));
            char endingChar = Character.toLowerCase(s.charAt(end));
            if(!isValidCharacter(startingChar)) {
                start++;
                continue;
            }
            if(!isValidCharacter(endingChar)) {
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

    public boolean isValidCharacter(char ch) {
        if((ch>=97&&ch<=122) || (ch>=65&&ch<=92) || (ch>=48 && ch<=57))
            return true;

        return false;    
    }

    // ABCDCBA
}
