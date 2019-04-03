package br.com.magrathea.twitterhashtag.twitterhashtagapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Hashtag;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.service.HashtagService;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.service.TweetService;

/**
 * Unit tests for API
 * 
 * @author kico
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterhashtagApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TwitterhashtagApiApplicationTests {
	

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private HashtagService hashtagService;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}


	@Test
	public void contextLoads() {
	}

	@Test
	public void setHashtags() {
		
		List<Hashtag> list = new ArrayList<Hashtag>();
		list.add(new Hashtag("TanoAr"));
		list.add(new Hashtag("Vascão"));
		
		hashtagService.removeAll();
		hashtagService.saveAll(list);
		
		List<Hashtag> newList = hashtagService.findAll(); 
		Assert.assertNotNull(newList);
	}

	@Test
	public void saveTweet() {
		Tweet t = new Tweet();
		t.setAuthor("Kicorj");
		t.setCreatedAt(new Date());
		List<String> list = new ArrayList<String>();
		list.add("TanoAr");
		t.setHashtagsFound(list);
		t.setMessage("Este é um tweet de teste com a hashtag #TanoAr ...");
		t.setPublishDate(new Date());
		t.setStatusId(12345);
		
		HttpEntity<Tweet> request = new HttpEntity<Tweet>(t);
	    ResponseEntity<Tweet> response = restTemplate.postForEntity(getRootUrl() + "/api/tweets", request, Tweet.class);
	    
	    Assert.assertNotNull(response.getBody());
	}


}
