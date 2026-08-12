class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        explorePermutations(nums,res,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }

    public void explorePermutations(int []nums, List<List<Integer>> res, List<Integer> recRes, boolean []visited) {
        if(recRes.size()==nums.length) {
            res.add(new ArrayList<>(recRes));
            return;
        }
        for(int idx=0;idx<nums.length;idx++) {
            if(visited[idx])
                continue;
            visited[idx] = true;
            recRes.add(nums[idx]);
            explorePermutations(nums,res,recRes,visited);
            visited[idx] = false;
            recRes.remove(recRes.size()-1);    
        }

    }
}
