package com.qualifyingOffer.Nisha.Controller;

import com.qualifyingOffer.Nisha.Model.Player;
import com.qualifyingOffer.Nisha.Service.CalculateQOffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import java.io.IOException;
import java.util.List;

@Controller
public class qOffer {

    private CalculateQOffer calculateQOffer;

    public qOffer(CalculateQOffer calculateQOffer) {
        this.calculateQOffer = calculateQOffer;
    }

    @GetMapping(value = "/getQualifyingOffer")
    public ResponseEntity<List<Player>> getQualifyingOffer() throws IOException {

        final List<Player> players = calculateQOffer.processPlayerData();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

}
