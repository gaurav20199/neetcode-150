class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for(String str:strs) {
            ans.append(str).append("é");
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int startingPtr = 0;
        for(int idx=0;idx<str.length();idx++) {
            if(str.charAt(idx)=='é') {
                res.add(str.substring(startingPtr,idx));
                startingPtr = idx+1;
            }
        }
        return res;
    }
}
