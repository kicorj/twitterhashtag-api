package br.com.magrathea.twitterhashtag.twitterhashtagapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Hashtag;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.repository.TwitterHashtagRepositoryInterface;

@Service
public class HashtagService extends AbstractTwitterHashtagService<Hashtag, String> {

	public HashtagService(TwitterHashtagRepositoryInterface<Hashtag, String> repository) {
		super(repository);
	}

	public void saveAll(List<Hashtag> hashtags) {
		for (Hashtag h : hashtags)
			repository.save(h);
	}
	
	public void removeAll() {
		repository.deleteAll();
	}
}
