package com.jenkings.sfgpetclinic.services.jpa;

import com.jenkings.sfgpetclinic.model.Owner;
import com.jenkings.sfgpetclinic.repository.OwnerRepository;
import com.jenkings.sfgpetclinic.repository.PetRepository;
import com.jenkings.sfgpetclinic.repository.PetTypeRepository;
import com.jenkings.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerServiceJpa implements OwnerService {


    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceJpa(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {

        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {

        Optional<Owner> ownerOptional = ownerRepository.findById(aLong);

        if(ownerOptional.isPresent()) {
            return ownerOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Owner save(Owner object) {

        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
