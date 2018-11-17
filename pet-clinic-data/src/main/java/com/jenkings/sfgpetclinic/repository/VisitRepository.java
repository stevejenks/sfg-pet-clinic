package com.jenkings.sfgpetclinic.repository;

import com.jenkings.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
