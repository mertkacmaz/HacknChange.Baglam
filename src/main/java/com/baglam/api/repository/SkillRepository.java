package com.baglam.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baglam.api.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

}
