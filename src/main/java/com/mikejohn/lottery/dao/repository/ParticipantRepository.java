package com.mikejohn.lottery.dao.repository;

import com.mikejohn.lottery.dao.entity.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long> {

    @Override
    List<Participant> findAll();
}
