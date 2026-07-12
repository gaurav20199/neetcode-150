class Solution {
    public boolean isAnagram(String s, String t) {
        int []freq = new int[26];
        for(int idx=0;idx<s.length();idx++) {
            int mappedIndex = (int) (s.charAt(idx)-'a');
            freq[mappedIndex]++;
        }

        for(int idx=0;idx<t.length();idx++) {
            int mappedIndex = (int) (t.charAt(idx)-'a');
            freq[mappedIndex]--;
        }

        for(int idx=0;idx<freq.length;idx++) {
            if(freq[idx]!=0)
                return false;
        }
        return true;
    }
}
