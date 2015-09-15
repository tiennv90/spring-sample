package com.spring.sample.training.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

	private CompactDisc compactDisc;
	
	@Autowired
	public CDPlayer(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}
	
	public String play() {
		return compactDisc.play();
	}

	public CompactDisc getCompactDisc() {
		return compactDisc;
	}

	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}
	

}
