package com.jenkings.sfgpetclinic.services.jpa;

import com.jenkings.sfgpetclinic.model.Owner;
import com.jenkings.sfgpetclinic.repository.OwnerRepository;
import com.jenkings.sfgpetclinic.repository.PetRepository;
import com.jenkings.sfgpetclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceJpa ownerServiceJpa;

    Owner returnOwner = Owner.builder().id(1L).build();


    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {

        String lastName = "Smith";
        Owner returnOwner = Owner.builder().id(1L).lastName(lastName).build();

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = ownerServiceJpa.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = ownerServiceJpa.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

        verify(ownerRepository).findAll();
    }

//    @Test
//    void findById() {
//
//        when(ownerRepository.findAllById(any())).thenReturn(Optional.of(returnOwner));
//
//        Owner owner = ownerServiceJpa.findById(1L);
//
//        assertNotNull(owner);
//    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner savedOwner = ownerServiceJpa.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {

        ownerServiceJpa.delete(returnOwner);

        verify(ownerRepository).delete(any());

    }

    @Test
    void deleteById() {

        ownerServiceJpa.deleteById(1L);

        verify(ownerRepository).deleteById(1L);
    }
}