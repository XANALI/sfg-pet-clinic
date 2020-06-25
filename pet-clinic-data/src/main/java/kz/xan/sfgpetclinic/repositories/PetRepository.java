package kz.xan.sfgpetclinic.repositories;

import kz.xan.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
