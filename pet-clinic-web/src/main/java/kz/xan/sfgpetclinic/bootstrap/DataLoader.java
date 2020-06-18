package kz.xan.sfgpetclinic.bootstrap;

import kz.xan.sfgpetclinic.model.Owner;
import kz.xan.sfgpetclinic.model.Vet;
import kz.xan.sfgpetclinic.service.OwnerService;
import kz.xan.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("Alikhan");
        owner.setLastName("Ryskhan");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Zhalgas");
        owner1.setLastName("Sarsen");

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
