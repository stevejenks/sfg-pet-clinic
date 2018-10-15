package com.jenkings.sfgpetclinic.bootstrap;

import com.jenkings.sfgpetclinic.model.Owner;
import com.jenkings.sfgpetclinic.model.Vet;
import com.jenkings.sfgpetclinic.services.OwnerService;
import com.jenkings.sfgpetclinic.services.VetService;
import com.jenkings.sfgpetclinic.services.map.OwnerServiceMap;
import com.jenkings.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

   private final OwnerService ownerService;
   private final VetService vetService;

   public DataLoader() {

      ownerService = new OwnerServiceMap();
      vetService = new VetServiceMap();
   }

   @Override
   public void run(String... args) throws Exception {

      Owner owner1 = new Owner();
      owner1.setId(1L);
      owner1.setFirstName("Bob");
      owner1.setLastName("Billows");

      ownerService.save(owner1);

      Owner owner2 = new Owner();
      owner2.setId(2L);
      owner2.setFirstName("Billy");
      owner2.setLastName("Marshmallow");

      ownerService.save(owner2);

      System.out.println("Loaded Owners");

      Vet vet1 = new Vet();
      vet1.setId(1L);
      vet1.setFirstName("Hannah");
      vet1.setLastName("J");

      vetService.save(vet1);

      Vet vet2 = new Vet();
      vet2.setId(2L);
      vet2.setFirstName("Jessie");
      vet2.setLastName("J");

      vetService.save(vet2);

      System.out.println("Loaded Vets");
   }
}
