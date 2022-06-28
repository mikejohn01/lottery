package com.mikejohn.lottery.dao.mapper;

import com.mikejohn.lottery.dao.dto.ParticipantDto;
import com.mikejohn.lottery.dao.dto.WinnerDto;
import com.mikejohn.lottery.dao.entity.Participant;
import com.mikejohn.lottery.dao.entity.Winner;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ParticipantDtoWinnerDtoMapper {
    WinnerDto toWinnerDTO(ParticipantDto participantDto);
}
