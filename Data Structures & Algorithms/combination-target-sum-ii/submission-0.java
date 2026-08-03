class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates,target,res,new ArrayList<>(),0);
        return res;
    }

    public void combinationSum2(int []candidates, int target, List<List<Integer>> res, List<Integer> uniqueRes,int idx) {
        if(target==0) {
            res.add(new ArrayList<>(uniqueRes));
            return;
        }
        if(target<0 || idx>=candidates.length)
            return;
            
        for(int i=idx;i<candidates.length;i++) {
            if(i>idx && candidates[i-1]==candidates[i])
                continue;

            uniqueRes.add(candidates[i]);
            combinationSum2(candidates,target-candidates[i],res,uniqueRes,i+1);
            uniqueRes.remove(uniqueRes.size()-1);
            
        }
    }
}
