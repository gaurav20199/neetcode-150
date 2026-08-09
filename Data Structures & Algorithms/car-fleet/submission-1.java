class Solution {
    class Pair implements Comparable<Pair> {
        int position;
        int time;

        public Pair(int position, int time) {
            this.position = position;
            this.time = time;
        }

        public int compareTo(Pair other) {
            return other.position-this.position;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> pairs = new ArrayList<>();
        for(int idx=0;idx<position.length;idx++) {
            pairs.add(new Pair(position[idx],speed[idx]));
        }
        Collections.sort(pairs);
        Stack<Double> stack = new Stack<>();
        for(Pair pair: pairs) {
            stack.push((double) (target - pair.position) / pair.time);
            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2)) {
                stack.pop();
            }

        }
        return stack.size();
    }
}
