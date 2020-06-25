package kz.xan.sfgpetclinic.services;

import kz.xan.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
