package kz.xan.sfgpetclinic.bootstrap;

import kz.xan.sfgpetclinic.model.*;
import kz.xan.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0 ){
            loadData();
        }
    }

    private void loadData() {
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

        Visit dogVisit = new Visit();
        dogVisit.setPet(mikesPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Cool Dog");

        visitService.save(dogVisit);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet = new Vet();
        vet.setFirstName("Ali");
        vet.setLastName("Baitas");
        vet.getSpecialities().add(savedRadiology);

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Timur");
        vet1.setLastName("Rakhmetulla");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        System.out.println(ownerService.findAll());
        System.out.println(vetService.findAll());
    }
}
