package br.com.magrathea.twitterhashtag.twitterhashtagapi.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.repository.TwitterHashtagRepositoryInterface;


@Service
public abstract class AbstractTwitterHashtagService <T, ID extends Serializable> implements TwitterHashtagServiceInterface<T, ID> {

	@Autowired
	protected TwitterHashtagRepositoryInterface<T, ID> repository;
	
	public AbstractTwitterHashtagService(TwitterHashtagRepositoryInterface<T, ID> repository) {
		this.repository = repository;
	}

	@Override
	public void save(T entity) {
		repository.save(entity);
	}

	@Override
	public T findById(ID id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

}
