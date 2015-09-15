package com.spring.sample.training.autowired;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
	
	private String title = "My Club";
	private String artist = "The Beatles";

	public String play() {
		return "Playing: " + title + " artist: " + artist;
	}

}
