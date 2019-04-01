package br.com.magrathea.twitterhashtag.twitterhashtagapi.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * Base Entity Class, other Entity classes will extends this one
 * @author kico
 */
public class BaseEntity {

	@Id
	protected String _id;
	protected Date createdAt;
	
	public BaseEntity() {
		super();
	}

	public BaseEntity(String _id, Date createdAt) {
		super();
		this._id = _id;
		this.createdAt = createdAt;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
