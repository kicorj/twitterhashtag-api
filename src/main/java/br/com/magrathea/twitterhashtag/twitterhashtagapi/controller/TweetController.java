package br.com.magrathea.twitterhashtag.twitterhashtagapi.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.Tweet;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.domain.TweetFilterResponse;
import br.com.magrathea.twitterhashtag.twitterhashtagapi.service.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
	@Autowired
	private TweetService tweetService;
	
	/**
	 * Remove the # symbol from first character if exists and convert to lowercase
	 * @param term
	 * @return
	 */
	private String formatHashtagTerm(String term) {
		if (StringUtils.isEmpty(term))
			return term;
		
		char firstChar = term.charAt(0);

	    if (firstChar == '#') {
	    	term = term.replaceFirst("#", "");
	    }
					
	    return term.toLowerCase();
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public TweetFilterResponse findAll(@RequestParam(required=false) String search, @RequestParam int offset, @RequestParam int limit) throws ServletException {
		int page = offset/limit;
	  return tweetService.findAllPageable(formatHashtagTerm(search), page, limit);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Tweet getHashtag(
	  @PathVariable String id) throws ServletException {
		return tweetService.findById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Tweet save(@RequestBody Tweet tweet) throws ServletException {
		tweetService.upsertTweet(tweet);
		
		return tweet;
	}
}
