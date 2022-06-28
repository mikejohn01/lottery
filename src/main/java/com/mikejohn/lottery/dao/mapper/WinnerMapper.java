package com.mikejohn.lottery.dao.mapper;

import com.mikejohn.lottery.dao.dto.ParticipantDto;
import com.mikejohn.lottery.dao.dto.WinnerDto;
import com.mikejohn.lottery.dao.entity.Participant;
import com.mikejohn.lottery.dao.entity.Winner;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.Collection;
import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface WinnerMapper {
    WinnerDto toDTO(Winner winner);
    List<WinnerDto> toDTOs(Collection<Winner> winner);

    Winner toModel(WinnerDto winnerDto);
    List<Winner> toModels(Collection<WinnerDto> winnerDto);
}
