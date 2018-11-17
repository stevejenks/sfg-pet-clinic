package com.jenkings.sfgpetclinic.services.jpa;

import com.jenkings.sfgpetclinic.model.Pet;
import com.jenkings.sfgpetclinic.repository.PetRepository;
import com.jenkings.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetServiceJpa implements PetService {

    private final PetRepository petRepositoy;

    public PetServiceJpa(PetRepository petRepositoy) {
        this.petRepositoy = petRepositoy;
    }

    @Override
    public Set<Pet> findAll() {

        Set<Pet> pets = new HashSet<>();

        petRepositoy.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Long aLong) {

        return petRepositoy.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {

        return petRepositoy.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepositoy.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepositoy.deleteById(aLong);
    }
}
