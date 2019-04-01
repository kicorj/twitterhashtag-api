package br.com.magrathea.twitterhashtag.twitterhashtagapi.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Hashtags that we will track
 * @author kico
 */
@Document(collection = "hashtags")
public class Hashtag extends BaseEntity {
	
	public Hashtag() {
		super();
	}

	public Hashtag(String hashtag) {
		super();
		this.hashtag = hashtag;
	}

	private String hashtag;

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
}
