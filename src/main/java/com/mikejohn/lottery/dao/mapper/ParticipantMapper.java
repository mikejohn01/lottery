package com.mikejohn.lottery.dao.mapper;

import com.mikejohn.lottery.dao.dto.ParticipantDto;
import com.mikejohn.lottery.dao.entity.Participant;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ParticipantMapper {
    ParticipantDto toDTO(Participant participant);

    List<ParticipantDto> toDTOs(Collection<Participant> model);

    Participant toModel(ParticipantDto participantDto);

    List<Participant> toModels(Collection<ParticipantDto> participantDtoS);
}
