package com.sg.gzf.learn.tdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sg.gzf.learn.tdd.dto.Link;
import com.sg.gzf.learn.tdd.service.UrlShortener;


@RestController
public class LinkController {
	private UrlShortener urlShortener;
	
	@GetMapping("shorten")
	@ResponseStatus(value = HttpStatus.CREATED)
	private Link getShortenedUrl(@RequestParam("fullUrl") String fullUrl) {
		return urlShortener.shorten(fullUrl);
	}
	
	@GetMapping("expand")
	@ResponseStatus(value = HttpStatus.OK)
	private Link getFullUrl(@RequestParam("shortenUrl") String shortedUrl) {
		return urlShortener.expand(shortedUrl);
	}

	
}
