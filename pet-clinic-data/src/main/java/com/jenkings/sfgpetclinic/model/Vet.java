package com.jenkings.sfgpetclinic.model;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Vet extends Person {

   private Set<Speciality> specialties;

   public Set<Speciality> getSpecialties() {
      return specialties;
   }

   public void setSpecialties(Set<Speciality> specialties) {
      this.specialties = specialties;
   }
}
