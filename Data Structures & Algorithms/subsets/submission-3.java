class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums,subsets,0,new ArrayList<>());
        return subsets; 
    }

    public void generateSubsets(int []nums, List<List<Integer>> subsets, int idx, List<Integer> res) {
        if(idx>=nums.length) {
            subsets.add(new ArrayList<>(res));
            return;
        }
        generateSubsets(nums,subsets,idx+1,res);
        res.add(nums[idx]);
        generateSubsets(nums,subsets,idx+1,res);
        res.remove(res.size() - 1);

        
    }

}
