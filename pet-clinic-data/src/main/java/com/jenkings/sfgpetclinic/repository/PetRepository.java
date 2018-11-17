package com.jenkings.sfgpetclinic.repository;

import com.jenkings.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
