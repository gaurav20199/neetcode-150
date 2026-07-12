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
    Map<Integer, List<Pair>> userIdToTweets;
    Map<Integer, Set<Integer>> userIdToFollowedUsers;

    public Twitter() {
        userIdToTweets = new HashMap<>();
        userIdToFollowedUsers = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        List<Pair> list = userIdToTweets.computeIfAbsent(userId, k -> new ArrayList<>());
        list.add(new Pair(time,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Pair> pairsToSort = new ArrayList<>(userIdToTweets.getOrDefault(userId,new ArrayList<>()));
        for(int followedUser: userIdToFollowedUsers.getOrDefault(userId,new HashSet<>())) {
            pairsToSort.addAll(userIdToTweets.getOrDefault(followedUser,new ArrayList<>()));   
        }
        
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
        userIdToFollowedUsers.putIfAbsent(followerId, new HashSet<>());
        userIdToFollowedUsers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)
            return;
        Set<Integer> followedUsers = userIdToFollowedUsers.getOrDefault(followerId,new HashSet<>());
        followedUsers.removeIf(id -> id.equals(followeeId));
        userIdToFollowedUsers.put(followerId,followedUsers); 
    }
}
