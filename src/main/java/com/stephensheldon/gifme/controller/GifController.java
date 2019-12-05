package com.stephensheldon.gifme.controller;

import com.stephensheldon.gifme.model.Gif;
import com.stephensheldon.gifme.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


/**
 * Author: Stephen Sheldon 11/21/19
 **/
@PropertySource("classpath:apikey.properties")
@Controller
public class GifController {

    private static Logger logger = LoggerFactory.getLogger(GifController.class);

    private RestTemplate restTemplate;

    @Value("${TENOR_API_KEY}")
    private String tenorApiKey;

    /**
     * Create a RestTemplateBuilder in this class so that its scope
     * is limited to just this class.
     * @param builder
     */
    public GifController(final RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


    @RequestMapping(value = "/")
    public String listTrending(Model model) {

        // Get 10 trending GIFS to display on homepage - this uses default locale of en_US
        final String url = String.format("https://api.tenor.com/v1/trending?key%1$s&limit=%2$s",
                tenorApiKey, 21);

        Result result = restTemplate.getForObject(url, Result.class);

        model.addAttribute("gifs", result.getResults());

        return "gif/index";
    }

    @RequestMapping("/search")
    public String searchResults(@RequestParam String q, Model model) {
        final String limit = "33";
        final String locale = "en_US";

        // Search request uses default locale of en_US
        final String url = String.format("https://api.tenor.com/v1/search?q=%1$s&key=%2$s&locale=%3$s&limit=%4$s",
                q, tenorApiKey, locale, limit);

        Result result = restTemplate.getForObject(url, Result.class);

        model.addAttribute("gifs", result.getResults());

        return "gif/index";
    }


    // Get a single gif page
    @RequestMapping("/gifs/{gifId}")
    public String gifDetails(@PathVariable String gifId, Model model) {
        // First let's check if the gif is already in our model
        final String url = String.format("https://api.tenor.com/v1/gifs?ids=%1$s&key=%2$s",
                gifId, tenorApiKey);

        Result result = restTemplate.getForObject(url, Result.class);

        Gif[] gif = result.getResults();
        model.addAttribute("singleGif", gif[0]);

        logger.info("TITLE IS: " + gif[0].getTitle());
        return "gif/details";
    }
}
