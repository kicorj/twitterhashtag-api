package br.com.magrathea.twitterhashtag.twitterhashtagapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.repository.TweetRepository;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.repository.TwitterHashtagRepositoryInterface;

@Service
public class TweetService extends AbstractTwitterHashtagService<Tweet, String> {

	@Autowired
	private TweetRepository tweetRepository;
	
	public TweetService(TwitterHashtagRepositoryInterface<Tweet, String> repository) {
		super(repository);
	}

	public void upsertTweet(Tweet tweet) {
		tweetRepository.upsertTweet(tweet);
	}
}
