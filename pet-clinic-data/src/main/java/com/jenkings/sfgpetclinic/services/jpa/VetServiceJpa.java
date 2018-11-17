package com.jenkings.sfgpetclinic.services.jpa;

import com.jenkings.sfgpetclinic.model.Vet;
import com.jenkings.sfgpetclinic.repository.VetRepositoy;
import com.jenkings.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetServiceJpa implements VetService {


    private final VetRepositoy vetRepositoy;

    public VetServiceJpa(VetRepositoy vetRepositoy) {
        this.vetRepositoy = vetRepositoy;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();

        vetRepositoy.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long aLong) {

        return vetRepositoy.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {

        return vetRepositoy.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepositoy.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepositoy.deleteById(aLong);
    }
}