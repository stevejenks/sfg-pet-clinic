package com.jenkings.sfgpetclinic.services;

import com.jenkings.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

   Vet findById(Long id);

   Vet findByLastName(String lastName);

   Vet save(Vet vet);

   Set<Vet> findAll();

}