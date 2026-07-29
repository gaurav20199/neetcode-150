class Solution {
    public int evalRPN(String[] tokens) {
       Map<String, java.util.function.BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
       map.put("+",(x,y) -> x+y);
       map.put("-",(x,y) -> x-y);
       map.put("*",(x,y) -> x*y);
       map.put("/",(x,y) -> y==0?0:x/y); 

       Stack<Integer> stack = new Stack<>();
       for(String token:tokens) {
            if(map.containsKey(token) && stack.size()>=2) {
                int firstEle = stack.pop();
                int secondEle = stack.pop();
                stack.push(map.get(token).apply(secondEle,firstEle));
            }else {
                stack.push(Integer.parseInt(token));
            }
       }
       return stack.peek();
    }
}
