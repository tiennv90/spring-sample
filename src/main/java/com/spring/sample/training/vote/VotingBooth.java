package com.spring.sample.training.vote;

import com.spring.sample.training.vote.nondip.Candidate;

public class VotingBooth {
	
	VoteRecorder voteRecorder = null;
	
	public void setVoteRecorder(VoteRecorder voteRecorder) {
		this.voteRecorder = voteRecorder;
	}
	
	public void record(Candidate candidate) {
		voteRecorder.record(candidate);
	}
}
