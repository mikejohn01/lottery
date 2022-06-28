package com.mikejohn.lottery.dao.repository;

import com.mikejohn.lottery.dao.entity.Participant;
import com.mikejohn.lottery.dao.entity.Winner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinnerRepository extends CrudRepository<Winner, Long> {

    @Override
    List<Winner> findAll();
}
