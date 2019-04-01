package br.com.magrathea.twitterhashtag.twitterhashtagapi.repository;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;

public interface TweetRepositoryCustom {

	public void upsertTweet(Tweet tweet);
}
