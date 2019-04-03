package br.com.magrathea.twitterhashtag.twitterhashtagapi.domain;

import java.util.List;

public class TweetFilterResponse extends Paginator {

	private List<Tweet> tweets;

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
}
