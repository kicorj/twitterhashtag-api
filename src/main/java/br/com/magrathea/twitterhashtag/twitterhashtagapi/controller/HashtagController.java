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

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Hashtag;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.service.HashtagService;

@RestController
@RequestMapping("/api/hashtags")
public class HashtagController {

	@Autowired
	private HashtagService hashtagService;
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public List<Hashtag> findAll() throws ServletException {
	  return hashtagService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Hashtag getHashtag(
	  @PathVariable String id) throws ServletException {
		return hashtagService.findById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void save(@RequestBody Hashtag hashtag) throws ServletException {
		hashtagService.save(hashtag);
	}
	
	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	public void save(@RequestBody List<Hashtag> hashtags) throws ServletException {
		hashtagService.removeAll();
		hashtagService.saveAll(hashtags);
	}
}
