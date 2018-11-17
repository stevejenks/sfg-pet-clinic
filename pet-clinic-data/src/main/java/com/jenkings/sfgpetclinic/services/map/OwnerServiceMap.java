package com.jenkings.sfgpetclinic.services.map;

import com.jenkings.sfgpetclinic.model.Owner;
import com.jenkings.sfgpetclinic.model.Pet;
import com.jenkings.sfgpetclinic.services.OwnerService;
import com.jenkings.sfgpetclinic.services.PetService;
import com.jenkings.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

   private final PetTypeService petTypeService;
   private final PetService petService;

   public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
      this.petTypeService = petTypeService;
      this.petService = petService;
   }


   @Override
   public Set<Owner> findAll() {
      return super.findAll();
   }

   @Override
   public Owner findById(Long id) {
      return super.findById(id);
   }

   @Override
   public Owner save(Owner owner) {

      if(owner != null){
         if(owner.getPets() != null){
            owner.getPets().forEach(pet -> {
               if(pet.getPetType() != null) {
                  if (pet.getPetType().getId() == null) {
                     pet.setPetType(petTypeService.save(pet.getPetType()));
                  }
               } else {
                  throw new RuntimeException("Pet type must be set on the pet object.");
               }

               if(pet.getId() == null) {
                  Pet savedPet = petService.save(pet);
                  pet.setId(savedPet.getId());
               }
            });
         }
         return super.save(owner);
      } else {
         return null;
      }
   }

   @Override
   public void delete(Owner object) {
      super.delete(object);
   }

   @Override
   public void deleteById(Long id) {
      super.deleteById(id);
   }

   @Override
   public Owner findByLastName(String lastName) {

      return super.findAll().stream()
              .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
              .findFirst()
              .orElse(null);
   }
}
