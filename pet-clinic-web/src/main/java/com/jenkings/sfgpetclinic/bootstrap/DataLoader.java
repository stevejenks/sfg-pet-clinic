package com.jenkings.sfgpetclinic.bootstrap;

import com.jenkings.sfgpetclinic.model.*;
import com.jenkings.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

   private final OwnerService ownerService;
   private final VetService vetService;
   private final PetTypeService petTypeService;
   private final SpecialityService specialitiesService;
   private final VisitService visitService;

   public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService, VisitService visitService) {
      this.ownerService = ownerService;
      this.vetService = vetService;
      this.petTypeService = petTypeService;
      this.specialitiesService = specialitiesService;
      this.visitService = visitService;
   }

   @Override
   public void run(String... args) throws Exception {

      int count = petTypeService.findAll().size();

      if(count == 0) {
         loadData();
      }
   }

   private void loadData() {
      PetType dog = new PetType();
      dog.setName("Dog");
      PetType savedDogPetType = petTypeService.save(dog);

      PetType cat = new PetType();
      cat.setName("Cat");
      PetType savedCatPetType = petTypeService.save(cat);

      Owner owner1 = Owner.builder().firstName("Bob").lastName("Billows").address("North Road").city("Miami").telephone("123-555-98765").pets(new HashSet<>()).build();

//      Owner owner1 = new Owner();
//      owner1.setFirstName("Bob");
//      owner1.setLastName("Billows");
//      owner1.setAddress("North Road");
//      owner1.setCity("Miami");
//      owner1.setTelephone("123-555-98765");

      Pet bobsPet = Pet.builder().petType(savedDogPetType).owner(owner1).name("Duke").birthday(LocalDate.now()).build();

//      Pet bobsPet = new Pet();
//      bobsPet.setPetType(savedDogPetType);
//      bobsPet.setOwner(owner1);
//      bobsPet.setName("Duke");
//      bobsPet.setBirthday(LocalDate.now());
      owner1.getPets().add(bobsPet);

      ownerService.save(owner1);

      Owner owner2 = Owner.builder().firstName("Billy").lastName("Marshmallow").address("South Road").city("London").telephone("321-555-56789").pets(new HashSet<>()).build();

//      Owner owner2 = new Owner();
//      owner2.setFirstName("Billy");
//      owner2.setLastName("Marshmallow");
//      owner2.setAddress("South Road");
//      owner2.setCity("London");
//      owner2.setTelephone("321-555-56789");

      Pet fionasCat = Pet.builder().petType(savedCatPetType).owner(owner2).birthday(LocalDate.now()).name("Marmalalde").build();

//      Pet fionasCat = new Pet();
//      fionasCat.setPetType(savedCatPetType);
//      fionasCat.setOwner(owner2);
//      fionasCat.setBirthday(LocalDate.now());
//      fionasCat.setName("Marmalalde");
      owner2.getPets().add(fionasCat);

      ownerService.save(owner2);

      Visit catVisit = new Visit();
      catVisit.setPet(fionasCat);
      catVisit.setDate(LocalDate.now());
      catVisit.setDescription("Snezing kitty");

      visitService.save(catVisit);

      System.out.println("Loaded Owners");

      Speciality radiology = new Speciality();
      radiology.setDescription("Radiology");
      Speciality savedRadiology = specialitiesService.save(radiology);

      Speciality surgery = new Speciality();
      surgery.setDescription("Surgery");
      Speciality savedSurgery = specialitiesService.save(surgery);

      Speciality dentistry = new Speciality();
      dentistry.setDescription("Dentistry");
      Speciality savedDentistry = specialitiesService.save(dentistry);

      Vet vet1 = new Vet();
      vet1.setFirstName("Hannah");
      vet1.setLastName("J");
      vet1.getSpecialities().add(savedDentistry);
      vet1.getSpecialities().add(savedSurgery);

      vetService.save(vet1);

      Vet vet2 = new Vet();
      vet2.setFirstName("Jessie");
      vet2.setLastName("J");
      vet2.getSpecialities().add(savedSurgery);
      vet2.getSpecialities().add(savedRadiology);

      vetService.save(vet2);

      System.out.println("Loaded Vets");
   }
}
