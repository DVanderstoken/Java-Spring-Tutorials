package com.fms.tutotrials.jpa.auditing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.tutotrials.jpa.auditing.model.Part;

@Repository
public interface PartRepository extends CrudRepository<Part, Long> {

}
