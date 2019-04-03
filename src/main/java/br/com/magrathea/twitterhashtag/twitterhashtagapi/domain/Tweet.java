package br.com.magrathea.twitterhashtag.twitterhashtagapi.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * Tweets collected by us  
 * @author kico
 */
@Document(collection = "tweets")
public class Tweet extends BaseEntity {

	@Indexed(name="statusId", unique = true)
	@JsonSerialize(using = ToStringSerializer.class)
	private long statusId;
	private Date publishDate;
	private String author;
	private String message;
	private List<String> hashtagsFound;
	
	public Tweet() {
		super();
	}
	public Tweet(String _id, Date createdAt) {
		super(_id, createdAt);
	}
	public Tweet(long statusId, Date publishDate, String author, String message, List<String> hashtagsFound) {
		super();
		this.statusId = statusId;
		this.publishDate = publishDate;
		this.author = author;
		this.message = message;
		this.hashtagsFound = hashtagsFound;
	}
	public long getStatusId() {
		return statusId;
	}
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getHashtagsFound() {
		return hashtagsFound;
	}
	public void setHashtagsFound(List<String> hashtagsFound) {
		this.hashtagsFound = hashtagsFound;
	}
	
}
