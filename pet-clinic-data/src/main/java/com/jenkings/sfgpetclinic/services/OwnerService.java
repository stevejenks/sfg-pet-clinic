package com.jenkings.sfgpetclinic.services;

import com.jenkings.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

   Owner findByLastName(String lastName);

}