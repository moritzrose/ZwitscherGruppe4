package com.brights.zwitscher.rank;

import com.brights.zwitscher.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
public class RankController {
    @GetMapping("rank")
    public RankDTO getCurrentRank(@ModelAttribute("sessionUser") Optional<User> sessionUserOptional){
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No valid login"));

      return new RankDTO(sessionUser.getId());
    }
}