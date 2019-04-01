package br.com.magrathea.twitterhashtag.twitterhashtagapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;

public class TweetRepositoryImpl implements TweetRepositoryCustom {

	@Autowired
	 MongoTemplate mongoTemplate;
	
	@Override
	public void upsertTweet(Tweet tweet) {
		
		Query query = new Query(Criteria.where("statusId").is(tweet.getStatusId()));
		
		Update update = new Update();
		update.set("author", tweet.getAuthor());
		update.set("message", tweet.getMessage());
		update.set("publishDate", tweet.getPublishDate());
		update.set("statusId", tweet.getStatusId());
		update.addToSet("hashtagsFound", tweet.getHashtagsFound().get(0));
		
//		mongoTemplate.findAndModify(query, update,
//                new FindAndModifyOptions().returnNew(true).upsert(false),
//                Tweet.class);
		
		mongoTemplate.upsert(query, update, Tweet.class);
	}

}
