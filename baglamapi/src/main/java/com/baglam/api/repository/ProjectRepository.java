package com.baglam.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baglam.api.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
