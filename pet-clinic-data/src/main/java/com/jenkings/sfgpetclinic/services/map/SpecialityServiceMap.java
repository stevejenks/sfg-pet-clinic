package com.jenkings.sfgpetclinic.services.map;

import com.jenkings.sfgpetclinic.model.Speciality;
import com.jenkings.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

   @Override
   public Speciality findById(Long id) {
      return super.findById(id);
   }

   @Override
   public Set<Speciality> findAll() {
      return super.findAll();
   }

   @Override
   public void deleteById(Long id) {
      super.deleteById(id);
   }

   @Override
   public void delete(Speciality object) {
      super.delete(object);
   }

   @Override
   public Speciality save(Speciality object) {
      return super.save(object);
   }
}
