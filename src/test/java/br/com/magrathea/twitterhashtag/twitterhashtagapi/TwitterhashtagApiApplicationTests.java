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
	
	@Autowired
	private TweetService tweetService;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}


	@Test
	public void contextLoads() {
	}
	

	@Test
	public void testGetAllHashtags() {
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
//		HttpMethod.GET, entity, String.class);
//		Assert.assertNotNull(response.getBody());
		
		 List<Hashtag> list = hashtagService.findAll();
		 Assert.assertNotNull(list);
	}
	
	@Test
	public void setHashtags() {
		
		List<Hashtag> list = new ArrayList<Hashtag>();
		list.add(new Hashtag("Vasco"));
		list.add(new Hashtag("Vascão"));
		
		hashtagService.removeAll();
		hashtagService.saveAll(list);
		
		List<Hashtag> newList = hashtagService.findAll(); 
		Assert.assertNotNull(newList);
	}

	@Test
	public void saveTweet() {
		Tweet t = new Tweet();
		t.setAuthor("Kico");
		t.setCreatedAt(new Date());
		List<String> list = new ArrayList<String>();
		list.add("Vascão campeão carioca");
		t.setHashtagsFound(list);
		t.setMessage("Blablablablabla...");
		t.setPublishDate(new Date());
		t.setStatusId(12345);
		
		tweetService.upsertTweet(t);
	}


//	@Test
//	public void testGetHashtagById() {
//	User user = restTemplate.getForObject(getRootUrl() + "/users/1", User.class);
//	System.out.println(user.getFirstName());
//	Assert.assertNotNull(user);
//	}

}
