package com.mikejohn.lottery.service;

import com.mikejohn.lottery.dao.dto.ParticipantDto;
import com.mikejohn.lottery.dao.dto.WinnerDto;
import com.mikejohn.lottery.dao.entity.Participant;
import com.mikejohn.lottery.dao.entity.Winner;
import com.mikejohn.lottery.dao.mapper.ParticipantMapper;
import com.mikejohn.lottery.dao.mapper.ParticipantDtoWinnerDtoMapper;
import com.mikejohn.lottery.dao.mapper.WinnerMapper;
import com.mikejohn.lottery.dao.repository.ParticipantRepository;
import com.mikejohn.lottery.dao.repository.WinnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class MainService {

    private final ParticipantRepository participantRepository;
    private final WinnerRepository winnerRepository;
    private final ParticipantMapper participantMapper;
    private final ParticipantDtoWinnerDtoMapper participantDtoWinnerDtoMapper;
    private final WinnerMapper winnerMapper;
    @Lazy
    private final MainService self;

    private final static String ERROR_START = "Игроков меньше двух!";

    @Transactional
    public void clearParticipants(){
        participantRepository.deleteAll();
    }

    public List<ParticipantDto> getAllParticipants(){
        return participantMapper.toDTOs(participantRepository.findAll());
    }

    public List<WinnerDto> getAllWinners(){
        return winnerMapper.toDTOs(winnerRepository.findAll());
    }

    public WinnerDto getWinner(){
        List<ParticipantDto> participants = getAllParticipants();
        if (participants.size()<2) {
            throw new RuntimeException(ERROR_START);
        }
        int winNumber = new Random().nextInt(participants.size());
        WinnerDto winnerDto = participantDtoWinnerDtoMapper.toWinnerDTO(participants.get(winNumber));
        winnerDto.setAmount(new Random().nextInt(1000));
        try {
            self.saveWinner(winnerMapper.toModel(winnerDto));
            self.clearParticipants();
            return winnerDto;
        } catch(Exception e){
            throw new RuntimeException();
        }
    }

    public Participant saveParticipant(ParticipantDto participantDto) {
        return participantRepository.save(participantMapper.toModel(participantDto));
    }

    @Transactional
    public void saveWinner(Winner winner){
        winnerRepository.save(winner);
    }
}
