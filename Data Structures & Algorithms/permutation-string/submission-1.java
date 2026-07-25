public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1FreqCount = new int[26];
        int[] s2FreqCount = new int[26];
        for (int idx = 0; idx < s1.length(); idx++) {
            s1FreqCount[s1.charAt(idx) - 'a']++;
            s2FreqCount[s2.charAt(idx) - 'a']++;
        }

        int matches = 0;
        for (int idx = 0; idx < 26; idx++) {
            if (s1FreqCount[idx] == s2FreqCount[idx]) {
                matches++;
            }
        }

        int start = 0;
        for (int end = s1.length(); end < s2.length(); end++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(end) - 'a';
            s2FreqCount[index]++;
            if (s1FreqCount[index] == s2FreqCount[index]) {
                matches++;
            } else if (s1FreqCount[index] + 1 == s2FreqCount[index]) {
                matches--;
            }

            index = s2.charAt(start) - 'a';
            s2FreqCount[index]--;
            if (s1FreqCount[index] == s2FreqCount[index]) {
                matches++;
            } else if (s1FreqCount[index] - 1 == s2FreqCount[index]) {
                matches--;
            }
            start++;
        }
        return matches == 26;
    }
}