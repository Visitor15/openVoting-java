package com.forged.openvoting.controllers.data;

import com.forged.openvoting.dao.VoteDataAccessor;
import com.forged.openvoting.voting_system.data.Vote;
import com.forged.openvoting.voting_system.data.VoteSubmissionResult;
import com.forged.openvoting.voting_system.data.VotingResult;
import com.forged.openvoting.voting_system.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * Created by visitor15 on 7/25/15.
 */
@Controller
@RequestMapping(value = "/voteAction")
public class VotingController {

    @Autowired
    VotingService votingService;

    @Autowired
    VoteDataAccessor voteDataAccessor;

    @ResponseBody
    @RequestMapping(value = "/updateVote/{voteId}", method = RequestMethod.PUT)
    public VotingResult vote(@PathVariable String voteId,
                             @RequestBody Vote vote) {
        return votingService.vote(voteId, vote);
    }

    @ResponseBody
    @RequestMapping(value = "/submitVote", method = RequestMethod.POST)
    public VoteSubmissionResult submitVote(@RequestBody Vote vote) {
        return votingService.submitVote(vote);
    }

    @ResponseBody
    @RequestMapping(value = "/vote/{voteId}", method = RequestMethod.GET)
    public Vote getVote(@PathVariable String voteId) {
        return voteDataAccessor.findById(voteId);
    }

    @ResponseBody
    @RequestMapping(value = "/emptyVote", method = RequestMethod.GET)
    public Vote startVoting() {
        return new Vote(UUID.randomUUID().toString(), "", "", new Date());
    }
}
