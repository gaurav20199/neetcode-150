class Tweet implements Comparable<Tweet> {
    int time;
    int tweetData;
    public Tweet(int time, int tweetData) {
        this.time = time;
        this.tweetData = tweetData;
    }

    public String toString() {
        return "["+ this.time + ","+this.tweetData+ "]";
    }

    public int compareTo(Tweet other) {
        return this.time-other.time;
    }
}

class User {
    int userId;
    Set<Integer> followers;
    List<Tweet> tweets;

    public User(int userId) {
        this.userId = userId;
        this.followers = new HashSet<>();
        this.tweets = new ArrayList<>();
    }

    public void addTweet(Tweet tweet) {
        this.tweets.add(0,tweet);
    }

    public void addFollowerIds(Integer followerId) {
        this.followers.add(followerId);
    }

     public void removeFollowerIds(Integer followerId) {
        this.followers.remove(followerId);
    }
}

class Twitter {
    private int time;
    Map<Integer,User> userIdToUser;
    public Twitter() {
        time = 0;
        userIdToUser = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        userIdToUser.putIfAbsent(userId,new User(userId));
        userIdToUser.get(userId).addTweet(new Tweet(time,tweetId));
    }

    private void addTop10TweetsForUser(Integer userId, PriorityQueue<Tweet> topTweets) {
        int counter = 0;
        for(Tweet tweet:userIdToUser.get(userId).tweets) {
            topTweets.add(tweet);  
            if(topTweets.size()>10) {
                topTweets.remove();
            }
            counter++;
            if (counter >= 10) 
                break;
              
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if(!userIdToUser.containsKey(userId))
            return res;

        PriorityQueue<Tweet> topTweets = new PriorityQueue<>();
        // insert follower tweets 
        for(Integer followerId:userIdToUser.get(userId).followers) {
            //System.out.println("here for user is::"+userId+" and follower id::"+followerId);
            addTop10TweetsForUser(followerId,topTweets);
        }
        // add own tweet
        addTop10TweetsForUser(userId,topTweets);
        int tweetsCount = 0;
        while(!topTweets.isEmpty() && tweetsCount<10) {
            res.addFirst(topTweets.remove().tweetData);
            tweetsCount++;
        }
        return res;
    }

    private boolean validateUser(int followerId, int followeeId) {
        return followerId!=followeeId;   
    }
    
    public void follow(int followerId, int followeeId) {
        if(!validateUser(followerId,followeeId))
            return;
        userIdToUser.putIfAbsent(followerId,new User(followerId));
        userIdToUser.putIfAbsent(followeeId,new User(followeeId));      
        userIdToUser.get(followerId).addFollowerIds(followeeId);        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!validateUser(followerId,followeeId))
            return;

        if(!userIdToUser.containsKey(followerId) || !userIdToUser.containsKey(followeeId))
            return;    
        userIdToUser.get(followerId).removeFollowerIds(followeeId);        

    }
}
