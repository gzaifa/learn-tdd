package com.sg.gzf.learn.tdd.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Link {
	
		
	@JsonProperty("long_url")
	private String longUrl;
	
	@Id
	@JsonProperty("short_url")
	private String shortUrl;
	
    @JsonIgnore
    private int clickCount;

    protected Link() {
        // for hibernate
    }
	
	public Link(String longUrl, String shortUrl) {

		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}
	
    public Link(String shortUrl, String longUrl, int clickCount) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.clickCount = clickCount;
    }
}
