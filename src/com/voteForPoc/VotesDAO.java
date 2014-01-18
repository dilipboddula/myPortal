package com.voteForPoc;

import java.util.ArrayList;
import java.util.List;

public interface VotesDAO {
	int insertVote(Votes v);
	boolean checkDuplicateVoteEntry(int scopeId,int nominatorId,int voteCompId);
	List getAllVotesStastics(int scopeId,int voteCompId);
	ArrayList<Votes> getCommentsStastics(int scopeId,int nomineeId,int voteCompId);

}
