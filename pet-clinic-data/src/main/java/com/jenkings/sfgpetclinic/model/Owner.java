package com.jenkings.sfgpetclinic.model;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Owner extends Person {

   private Set<Pet> pets;

   public Set<Pet> getPets() {
      return pets;
   }

   public void setPets(Set<Pet> pets) {
      this.pets = pets;
   }
}
