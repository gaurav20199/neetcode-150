class Solution {
    class Pair {
        int value;
        int idx;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();
        for(int idx=temperatures.length-1;idx>=0;idx--) {
            while(!stack.isEmpty() && stack.peek().value<=temperatures[idx]) {
                stack.pop();
            }
            //System.out.println(stack.size()+","+idx);
            res[idx] = stack.isEmpty()?0:stack.peek().idx-idx;
            stack.push(new Pair(temperatures[idx],idx));
        }
        return res;
    }
}
