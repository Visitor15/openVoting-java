package com.forged.openvoting.controllers.data;

import com.forged.openvoting.dto.BallotDTO;
import com.forged.openvoting.dto.BallotSubmissionResultDTO;
import com.forged.openvoting.voting_system.builders.BallotBuilder;
import com.forged.openvoting.voting_system.data.BallotGroup;
import com.forged.openvoting.voting_system.factories.BallotGroupFactory;
import com.forged.openvoting.voting_system.service.BallotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

/**
 * Created by visitor15 on 7/27/15.
 */
@Controller
@RequestMapping(value = "/ballotAction")
public class BallotController {

    @Autowired
    BallotService ballotService;

    @ResponseBody
    @RequestMapping(value = "/get/{ballotId}", method = RequestMethod.GET)
    public BallotDTO getBallot(@PathVariable final String ballotId) {
        return ballotService.findBallotDTOById(ballotId);
    }

    @ResponseBody
    @RequestMapping(value = "/submitBallot", method = RequestMethod.POST)
    public BallotSubmissionResultDTO submitBallot(@RequestBody BallotDTO ballotDTO) {
        return ballotService.submitBallotForVoting(ballotDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/emptyBallot", method = RequestMethod.GET)
    public BallotDTO getEmptyBallot() {
//        return new BallotDTO();
        return new BallotDTO(new BallotBuilder().builder()
                .setBallotGroup(new BallotGroup())
                .setCreationDate(new Date())
                .setTitle("Empty Ballot")
                .setDescription("Ballot description for an empty ballot!")
                .setSummary("Hello, I'm a summary and I have this empty ballot I'm handing out. Free of charge.")
                .setUpVoteCount(0L)
                .setDownVoteCount(0L)
                .setId(UUID.randomUUID().toString())
                .setReasonForBallot(new HashSet<String>() {{
                    add("Reason 1.");
                    add("Reason 2.");
                    add("Reason 3.");
                }})
                .build());
    }
}
