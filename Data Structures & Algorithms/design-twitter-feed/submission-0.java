class Twitter {

    List<int[]> tweets = new ArrayList<>();
    HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();

        for (int i = tweets.size() - 1; i >= 0 && feed.size() < 10; i--) {

            int[] tweet = tweets.get(i);

            if (tweet[0] == userId ||
                (hash.containsKey(userId) &&
                 hash.get(userId).contains(tweet[0]))) {

                feed.add(tweet[1]);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        hash.putIfAbsent(followerId, new HashSet<>());
        hash.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (hash.containsKey(followerId)) {
            hash.get(followerId).remove(followeeId);
        }
    }
}