package com.mikejohn.lottery.controller;

import com.mikejohn.lottery.dao.dto.ParticipantDto;
import com.mikejohn.lottery.dao.dto.WinnerDto;
import com.mikejohn.lottery.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/lottery")
public class MainController {

    private final MainService mainService;

    @GetMapping("/participant")
    List<ParticipantDto> getParticipants() {
        return mainService.getAllParticipants();
    };

    @GetMapping("/winners")
    List<WinnerDto> getWinners() {
        return mainService.getAllWinners();
    };

    @PostMapping("/participant")
    ResponseEntity saveParticipant(@RequestBody ParticipantDto participantDto) {
        try {
            mainService.saveParticipant(participantDto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @GetMapping("/start")
    WinnerDto start() {
        return mainService.getWinner();
    };

}
