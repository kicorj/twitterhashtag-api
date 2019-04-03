package br.com.magrathea.twitterhashtag.twitterhashtagapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.TweetFilterResponse;
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
	
	public TweetFilterResponse findAllPageable(String search, int page, int rowsPerPage) {
		Pageable pageable = PageRequest.of(page, rowsPerPage);
		
		Page<Tweet> tweetPage = StringUtils.isEmpty(search) ? tweetRepository.findAllByOrderByPublishDateDesc(pageable): tweetRepository.findAllByHashtagsFoundInIgnoreCaseOrderByPublishDateDesc(search, pageable);
		
		TweetFilterResponse tweetFilterResponse = new TweetFilterResponse();
		
		tweetFilterResponse.setPage(page);
		tweetFilterResponse.setPageSize(tweetPage.getSize());
		tweetFilterResponse.setTotal(tweetPage.getTotalElements());
		tweetFilterResponse.setTotalPages(tweetPage.getTotalPages());
		tweetFilterResponse.setTweets(tweetPage.getContent());
		
		return tweetFilterResponse;
	}
}
