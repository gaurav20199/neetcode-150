class Solution {
    public int[] productExceptSelf(int[] nums) {
        int maxProduct = 1;
        int []res = new int[nums.length];
        Set<Integer> zeroPos = new HashSet<>();
        for(int idx=0;idx<nums.length;idx++) {
            int num = nums[idx];
            if(num==0) {
                zeroPos.add(idx);
                continue;
            }
            maxProduct*=num;
        }
        //System.out.println(maxProduct);
        for(int idx=0;idx<nums.length;idx++) {
            if(zeroPos.contains(idx)){
                if(zeroPos.size()==1) {
                    res[idx] = maxProduct;
                }else {
                    res[idx] = 0;
                }
           }else {
               if(zeroPos.isEmpty())
                    res[idx] = maxProduct/nums[idx];
                else
                    res[idx] = 0;     
            }
        }
        return res;

        // idx is zero and there is no other zero -> maxProduct
        // idx is non zero and there is no other zero -> maxProduct/given number
        // idx is zero and there is another zero -> 0
        // idx is non zero and there is another zero -> 0
    }
}  
