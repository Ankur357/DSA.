package Queue;

import java.util.*;

public class Twitter {
    private static int timeStamp = 0;

    // User class to represent each user
    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // Each user follows themselves initially
            tweetHead = null;
        }

        // Follow another user
        public void follow(int id) {
            followed.add(id);
        }

        // Unfollow a user (can't unfollow themselves)
        public void unfollow(int id) {
            if (this.id != id) followed.remove(id);
        }

        // Post a tweet
        public void post(int id) {
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead; // Add new tweet to the top of the list
            tweetHead = newTweet;
        }
    }

    // Tweet class to represent each tweet
    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++; // Increment the timestamp to ensure order
            next = null;
        }
    }

    // Map to store the user information by user ID
    private Map<Integer, User> userMap;

    // Constructor for Twitter class
    public Twitter() {
        userMap = new HashMap<>();
    }

    // Post a tweet for a user
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId); // Create new user if not already in the map
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    // Get the news feed for a user
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();
        if (!userMap.containsKey(userId)) return newsFeed;

        // Get the list of users followed by the user
        Set<Integer> followedUsers = userMap.get(userId).followed;

        // Priority queue to store the tweets in order of time (max heap)
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(followedUsers.size(), (a, b) -> b.time - a.time);

        // Add the most recent tweet from each followed user
        for (int user : followedUsers) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                tweetHeap.add(tweet);
            }
        }

        // Retrieve up to 10 most recent tweets
        int count = 0;
        while (!tweetHeap.isEmpty() && count < 10) {
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id); // Add the tweet ID to the news feed
            count++;
            if (tweet.next != null) {
                tweetHeap.add(tweet.next); // Add the next tweet if it exists
            }
        }

        return newsFeed;
    }

    // Follow a user
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }
        if (!userMap.containsKey(followeeId)) {
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }
        userMap.get(followerId).follow(followeeId);
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    // Main method to test the Twitter system
    public static void main(String[] args) {
        // Create Twitter instance
        Twitter twitter = new Twitter();

        // User 1 posts a tweet
        twitter.postTweet(1, 5);

        // User 1's news feed (should have tweet 5)
        System.out.println(twitter.getNewsFeed(1)); // Output: [5]

        // User 1 follows user 2
        twitter.follow(1, 2);

        // User 2 posts a tweet
        twitter.postTweet(2, 6);

        // User 1's news feed (should have tweets 6 and 5)
        System.out.println(twitter.getNewsFeed(1)); // Output: [6, 5]

        // User 1 unfollows user 2
        twitter.unfollow(1, 2);

        // User 1's news feed (should have only tweet 5)
        System.out.println(twitter.getNewsFeed(1)); // Output: [5]
    }
}
