package com.spring.sample.training.vote;

import java.util.HashMap;
import java.util.Map;

import com.spring.sample.training.vote.nondip.Candidate;

public class LocalVoteRecorder implements VoteRecorder {

	Map<Candidate, Integer> votes = new HashMap<Candidate, Integer>();
	
	public void record(Candidate candidate) {
		
		int count = 0;
		
		if (votes.containsKey(candidate)) {
			count = votes.get(candidate);
		} else {
			votes.put(candidate, count);
		}
		
		count ++;
		votes.put(candidate, count);
	}

}
