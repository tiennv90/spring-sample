package com.spring.sample.training.aop.track;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	
	private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();
	
	@Pointcut("execution(com.spring.sample.training.aop.track.CompactDisk.playTrack(int)) && args(trackNumber)")
	public void trackPlayed(int trackNumber) {}
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber) {
		
		int count = 0;
		if (trackCounts.containsKey(trackNumber)) {
			count = trackCounts.get(trackNumber);
		}
		trackCounts.put(trackNumber, count + 1);
	}
}
