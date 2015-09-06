package com.spring.sample.training.vote.nondip;

import java.util.HashMap;
import java.util.Map;

public class VotingBooth {
	
	class VoteRecorder {
		Map<Candidate, Integer> hVotes = new HashMap<Candidate, Integer>();
		
		public void record(Candidate candidate) {
			
			int count = 0;
			if (hVotes.containsKey(candidate)) {
				count = hVotes.get(candidate);
			} else {
				hVotes.put(candidate, count);
			}
			count ++;
			
			hVotes.put(candidate, count);
		}
	}
	
	public static void main(String args[]) {
		
	}
	
}
