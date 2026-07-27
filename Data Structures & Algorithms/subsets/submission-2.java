class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums,subsets,0,new ArrayList<>());
        return subsets; 
    }

    public List<Integer> createSubList(String str) {
        //System.out.println(str);
        List<Integer> res = new ArrayList<>();
        for(int idx=0;idx<str.length();idx++) {
            char ch = str.charAt(idx);
            if(ch=='-') {
                idx++;
                res.add(-(int)(str.charAt(idx)-'0'));
            }else {
                res.add((int)(ch-'0'));
            }  
        }
        return res;
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
