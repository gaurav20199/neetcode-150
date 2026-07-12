class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> wordToAnagrams = new HashMap<>();
       for(String word:strs) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            if(wordToAnagrams.containsKey(sortedStr)) {
                wordToAnagrams.get(sortedStr).add(word);
            }else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                wordToAnagrams.put(sortedStr,anagrams);
            }
       }
       return new ArrayList<>(wordToAnagrams.values()); 
    }
}
