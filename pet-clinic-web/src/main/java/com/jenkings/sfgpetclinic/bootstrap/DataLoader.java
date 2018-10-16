package com.jenkings.sfgpetclinic.bootstrap;

import com.jenkings.sfgpetclinic.model.Owner;
import com.jenkings.sfgpetclinic.model.Vet;
import com.jenkings.sfgpetclinic.services.OwnerService;
import com.jenkings.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

   private final OwnerService ownerService;
   private final VetService vetService;

   public DataLoader(OwnerService ownerService, VetService vetService) {
      this.ownerService = ownerService;
      this.vetService = vetService;
   }

   @Override
   public void run(String... args) throws Exception {

      Owner owner1 = new Owner();
      owner1.setFirstName("Bob");
      owner1.setLastName("Billows");

      ownerService.save(owner1);

      Owner owner2 = new Owner();
      owner2.setFirstName("Billy");
      owner2.setLastName("Marshmallow");

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
