package com.mikejohn.lottery.controller;

import com.mikejohn.lottery.dao.dto.ParticipantDto;
import com.mikejohn.lottery.dao.dto.WinnerDto;
import com.mikejohn.lottery.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Lottery")
@AllArgsConstructor
@RestController
@RequestMapping("/lottery")
public class MainController {

    private final MainService mainService;

    @ApiOperation("Получить список участников")
    @GetMapping("/participant")
    List<ParticipantDto> getParticipants() {
        return mainService.getAllParticipants();
    };

    @ApiOperation("Получить список победителей")
    @GetMapping("/winners")
    List<WinnerDto> getWinners() {
        return mainService.getAllWinners();
    };

    @ApiOperation("Сохранить нового участника")
    @PostMapping("/participant")
    ResponseEntity saveParticipant(@RequestBody ParticipantDto participantDto) {
        try {
            mainService.saveParticipant(participantDto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @ApiOperation("Начать лотерею")
    @GetMapping("/start")
    WinnerDto start() {
        return mainService.getWinner();
    };

}
