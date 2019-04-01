package br.com.magrathea.twitterhashtag.twitterhashtagapi.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TwitterHashtagRepositoryInterface<T, ID extends Serializable> extends MongoRepository<T, ID> {

}
