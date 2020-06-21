package kz.xan.sfgpetclinic.bootstrap;

import kz.xan.sfgpetclinic.model.Owner;
import kz.xan.sfgpetclinic.model.Pet;
import kz.xan.sfgpetclinic.model.PetType;
import kz.xan.sfgpetclinic.model.Vet;
import kz.xan.sfgpetclinic.service.OwnerService;
import kz.xan.sfgpetclinic.service.PetTypeService;
import kz.xan.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Alikhan");
        owner.setLastName("Ryskhan");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Zhalgas");
        owner1.setLastName("Sarsen");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Vet vet = new Vet();
        vet.setFirstName("Ali");
        vet.setLastName("Baitas");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Timur");
        vet1.setLastName("Rakhmetulla");

        vetService.save(vet1);

        System.out.println(ownerService.findAll());
        System.out.println(vetService.findAll());
    }
}
