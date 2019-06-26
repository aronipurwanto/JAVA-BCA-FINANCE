package com.bcaf.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.crud.model.JobTitleModel;

@Repository
public interface JobtitleRepo extends JpaRepository<JobTitleModel, Integer> {

}
