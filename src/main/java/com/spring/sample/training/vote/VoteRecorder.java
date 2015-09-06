package com.spring.sample.training.vote;

import com.spring.sample.training.vote.nondip.Candidate;

public interface VoteRecorder {
	public void record(Candidate candidate);
}
