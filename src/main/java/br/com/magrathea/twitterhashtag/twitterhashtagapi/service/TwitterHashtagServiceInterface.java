package br.com.magrathea.twitterhashtag.twitterhashtagapi.service;

import java.io.Serializable;
import java.util.List;

public interface TwitterHashtagServiceInterface<T, ID extends Serializable> {

	void save(T entity);
    T findById(ID id);
    List<T> findAll();
}
