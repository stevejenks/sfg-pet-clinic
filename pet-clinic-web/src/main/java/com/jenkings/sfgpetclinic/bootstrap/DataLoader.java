package com.jenkings.sfgpetclinic.bootstrap;

import com.jenkings.sfgpetclinic.model.Owner;
import com.jenkings.sfgpetclinic.model.Pet;
import com.jenkings.sfgpetclinic.model.PetType;
import com.jenkings.sfgpetclinic.model.Vet;
import com.jenkings.sfgpetclinic.services.OwnerService;
import com.jenkings.sfgpetclinic.services.PetTypeService;
import com.jenkings.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

   private final OwnerService ownerService;
   private final VetService vetService;
   private final PetTypeService petTypeService;

   public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
      this.ownerService = ownerService;
      this.vetService = vetService;
      this.petTypeService = petTypeService;
   }

   @Override
   public void run(String... args) throws Exception {

      PetType dog = new PetType();
      dog.setName("Dog");
      PetType savedDogPetType = petTypeService.save(dog);

      PetType cat = new PetType();
      cat.setName("Cat");
      PetType savedCatPetType = petTypeService.save(cat);

      Owner owner1 = new Owner();
      owner1.setFirstName("Bob");
      owner1.setLastName("Billows");
      owner1.setAddress("North Road");
      owner1.setCity("Miami");
      owner1.setTelephone("123-555-98765");

      Pet bobsPet = new Pet();
      bobsPet.setPetType(savedDogPetType);
      bobsPet.setOwner(owner1);
      bobsPet.setName("Duke");
      bobsPet.setBirthday(LocalDate.now());
      owner1.getPets().add(bobsPet);

      ownerService.save(owner1);

      Owner owner2 = new Owner();
      owner2.setFirstName("Billy");
      owner2.setLastName("Marshmallow");
      owner2.setAddress("South Road");
      owner2.setCity("London");
      owner2.setTelephone("321-555-56789");

      Pet fionasCat = new Pet();
      fionasCat.setPetType(savedCatPetType);
      fionasCat.setOwner(owner2  );
      fionasCat.setBirthday(LocalDate.now());
      fionasCat.setName("Marmalalde");
      owner2.getPets().add(fionasCat);

      ownerService.save(owner2);

      System.out.println("Loaded Owners");

      Vet vet1 = new Vet();
      vet1.setFirstName("Hannah");
      vet1.setLastName("J");

      vetService.save(vet1);

      Vet vet2 = new Vet();
      vet2.setFirstName("Jessie");
      vet2.setLastName("J");

      vetService.save(vet2);

      System.out.println("Loaded Vets");
   }
}
