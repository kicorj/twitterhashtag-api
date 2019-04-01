package br.com.magrathea.twitterhashtag.twitterhashtagapi.controller;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.service.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
	@Autowired
	private TweetService tweetService;
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public List<Tweet> findAll() throws ServletException {
	  return tweetService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Tweet getHashtag(
	  @PathVariable String id) throws ServletException {
		return tweetService.findById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void save(@RequestBody Tweet tweet) throws ServletException {
		tweetService.upsertTweet(tweet);
	}
}
