package com.spring.sample.training.aop.track;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc {

	private String title;
	private List<String> tracks = new ArrayList<String>();
	private String artist;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void playTrack(int trackNumber) {
		System.out.println("Playing Track Id: " + trackNumber + " name: " + tracks.get(trackNumber));
	}
	
}
