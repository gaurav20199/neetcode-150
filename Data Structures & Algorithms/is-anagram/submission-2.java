class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int []freq = new int[26];
        for(int idx=0;idx<s.length();idx++) {
            freq[(int) (s.charAt(idx)-'a')]++;
            freq[(int) (t.charAt(idx)-'a')]--;
        }

        for(int val:freq) {
            if(val!=0)
                return false;
        }
        return true;
    }
}
