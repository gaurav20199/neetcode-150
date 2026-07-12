class Twitter {
    private int time;
    private class Pair implements Comparable<Pair> {
        int time;
        int tweetData;
        public Pair(int time, int tweetData) {
            this.time = time;
            this.tweetData = tweetData;
        }

        public String toString() {
            return "["+ this.time + ","+this.tweetData+ "]";
        }

        public int compareTo(Pair other) {
            return other.time-this.time;
        }
    }

    // tracking latest 10 posts
    // also tracking which operation was done last so that tweets will be displayed on basis of it
    Map<Integer, Deque<Pair>> userIdToTweets;
    Map<Integer, Set<Integer>> userIdToFollowedUsers;

    public Twitter() {
        userIdToTweets = new HashMap<>();
        userIdToFollowedUsers = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        Deque<Pair> deque = userIdToTweets.computeIfAbsent(userId, k -> new ArrayDeque<>());
        deque.addFirst(new Pair(time,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Pair> pairsToSort = new ArrayList<>();
        if(userIdToTweets.containsKey(userId))
            pairsToSort.addAll(userIdToTweets.get(userId));
        //System.out.println(pairsToSort+","+userId);
        //System.out.println("followed users count::"+userIdToFollowedUsers.get(userId));
        if(userIdToFollowedUsers.containsKey(userId)) {
            for(int followedUser: userIdToFollowedUsers.get(userId)) {
                //System.out.println(followedUser);
                if(followedUser==userId)
                    continue;
                if(userIdToTweets.containsKey(followedUser)) {
                    pairsToSort.addAll(userIdToTweets.get(followedUser));
                }
            }
        }
        //System.out.println(pairsToSort);
        Collections.sort(pairsToSort);
        for(Pair pair:pairsToSort) {
            if(res.size()>=10)
                break;
            res.add(pair.tweetData);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
            return;
        Set<Integer> followedUsers = userIdToFollowedUsers.getOrDefault(followeeId,new HashSet<>());
        followedUsers.add(followeeId);
        userIdToFollowedUsers.put(followerId,followedUsers);
        //System.out.println("followed");
    }
    
    public void unfollow(int followerId, int followeeId) {
          if(followerId==followeeId)
            return;
        Set<Integer> followedUsers = userIdToFollowedUsers.getOrDefault(followeeId,new HashSet<>());
        followedUsers.removeIf(id -> id.equals(followeeId));
        userIdToFollowedUsers.put(followerId,followedUsers); 
    }
}
