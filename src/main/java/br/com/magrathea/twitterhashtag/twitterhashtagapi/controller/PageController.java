package br.com.magrathea.twitterhashtag.twitterhashtagapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    @GetMapping({"/", "/tracker"})
    public String main(Model model) {
        return "tracker";
    }
    
    @GetMapping("/tweets")
    public String tweets(Model model) {
        return "tweets";
    }
}
