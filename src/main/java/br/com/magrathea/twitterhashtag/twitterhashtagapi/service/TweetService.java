package br.com.magrathea.twitterhashtag.twitterhashtagapi.service;

import org.springframework.stereotype.Service;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.repository.TwitterHashtagRepositoryInterface;

@Service
public class TweetService extends AbstractTwitterHashtagService<Tweet, String> {

	public TweetService(TwitterHashtagRepositoryInterface<Tweet, String> repository) {
		super(repository);
	}

}
