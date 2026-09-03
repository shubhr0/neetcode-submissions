class Twitter {

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    int timestamp = 0;

    HashMap<Integer, HashSet<Integer>> followMap = new HashMap<>();

    HashMap<Integer, List<Tweet>> tweetMap = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweetMap.containsKey(userId)) {
            for (Tweet t : tweetMap.get(userId))
                pq.offer(t);
        }

        if (followMap.containsKey(userId)) {

            for (int followee : followMap.get(userId)) {

                if (tweetMap.containsKey(followee)) {

                    for (Tweet t : tweetMap.get(followee))
                        pq.offer(t);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && ans.size() < 10)
            ans.add(pq.poll().tweetId);

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
    }
}