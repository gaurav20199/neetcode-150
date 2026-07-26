class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(nums,target,new ArrayList<>(),res,0,0);
        return res;
    }

    public void combinationSum(int []candidates, int target,List<Integer> ans,List<List<Integer>> res,int curSum,int curIdx) {
        if(curSum>target)
            return;

        if(curSum==target) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int idx=curIdx;idx<candidates.length;idx++) {
              ans.add(candidates[idx]);
              combinationSum(candidates,target,ans,res,curSum+candidates[idx],idx);
              ans.remove(ans.size()-1);  
        }

    }
}
