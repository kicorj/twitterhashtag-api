package br.com.magrathea.twitterhashtag.twitterhashtagapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;

public interface TweetRepository extends TwitterHashtagRepositoryInterface<Tweet, String>, TweetRepositoryCustom, PagingAndSortingRepository<Tweet, String> {

	public Page<Tweet> findAllByOrderByPublishDateDesc(Pageable pageable);
	public Page<Tweet> findAllByHashtagsFoundInIgnoreCaseOrderByPublishDateDesc(String hashtagsFound, Pageable pageable);
}
