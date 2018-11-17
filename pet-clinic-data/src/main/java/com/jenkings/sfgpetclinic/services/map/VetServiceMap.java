package com.jenkings.sfgpetclinic.services.map;

import com.jenkings.sfgpetclinic.model.Speciality;
import com.jenkings.sfgpetclinic.model.Vet;
import com.jenkings.sfgpetclinic.services.SpecialityService;
import com.jenkings.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

   private SpecialityService specialityService;

   public VetServiceMap(SpecialityService specialityService) {
      this.specialityService = specialityService;
   }


   @Override
   public Set<Vet> findAll() {
      return super.findAll();
   }

   @Override
   public Vet findById(Long id) {
      return super.findById(id);
   }

   @Override
   public Vet save(Vet object) {

      if(object.getSpecialities().size() > 0){
         object.getSpecialities().forEach(speciality -> {
            if(speciality.getId() == null) {
               Speciality savedSpeciality = specialityService.save(speciality);
               speciality.setId(savedSpeciality.getId());
            }
         });
      }
      return super.save(object);
   }

   @Override
   public void delete(Vet object) {
      super.delete(object);
   }

   @Override
   public void deleteById(Long id) {
      super.deleteById(id);
   }
}
