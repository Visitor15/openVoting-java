package com.forged.openvoting.controllers.data;

import com.forged.openvoting.dto.BallotDTO;
import com.forged.openvoting.dto.BallotSubmissionResultDTO;
import com.forged.openvoting.voting_system.service.BallotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by visitor15 on 7/27/15.
 */
@Controller(value = "/ballot-action")
public class BallotController {

    @Autowired
    BallotService ballotService;

    @ResponseBody
    @RequestMapping(value = "/get/{ballotId}", method = RequestMethod.GET)
    public BallotDTO getBallot(@PathVariable final String ballotId) {
        return ballotService.findBallotDTOById(ballotId);
    }

    @ResponseBody
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public BallotSubmissionResultDTO submitBallot(@RequestBody BallotDTO ballotDTO) {
        return ballotService.submitBallotForVoting(ballotDTO);
    }
}
