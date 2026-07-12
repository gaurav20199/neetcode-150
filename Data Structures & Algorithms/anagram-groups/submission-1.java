class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> wordToAnagrams = new HashMap<>();
       for(String word:strs) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            wordToAnagrams.putIfAbsent(sortedStr,new ArrayList<>());
            wordToAnagrams.get(sortedStr).add(word);
       }
       return new ArrayList<>(wordToAnagrams.values()); 
    }
}
