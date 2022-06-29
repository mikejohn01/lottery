package com.mikejohn.lottery.service;

import com.mikejohn.lottery.dao.dto.ParticipantDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Disabled
public class MainServiceTest {

    @Autowired
    private MainService service;

    @Test
    void saveAndFindParticipantsInDB() {
        List<ParticipantDto> participants = makeParticipant();
        for (ParticipantDto participant : participants) {
            service.saveParticipant(participant);
        }
        List<ParticipantDto> findedParticipants = service.getAllParticipants();
        assertTrue(participants.containsAll(findedParticipants));
    }

    List<ParticipantDto> makeParticipant() {
        List<ParticipantDto> list = new ArrayList<>();
        ParticipantDto participantDto = new ParticipantDto();
        list.add(participantDto.builder()
                .age(34)
                .city("СПб")
                .name("Михаил1")
                .build());
        ParticipantDto participantDto2 = new ParticipantDto();
        list.add(participantDto2.builder()
                .age(34)
                .city("СПб")
                .name("Михаил2")
                .build());
        return list;
    }
}
