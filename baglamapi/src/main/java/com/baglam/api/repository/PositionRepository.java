package com.baglam.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baglam.api.entity.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {

}
