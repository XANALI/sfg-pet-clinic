package kz.xan.sfgpetclinic.bootstrap;

import kz.xan.sfgpetclinic.model.Owner;
import kz.xan.sfgpetclinic.model.Vet;
import kz.xan.sfgpetclinic.service.OwnerService;
import kz.xan.sfgpetclinic.service.VetService;
import kz.xan.sfgpetclinic.service.map.OwnerServiceMap;
import kz.xan.sfgpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Alikhan");
        owner.setLastName("Ryskhan");

        ownerService.save(owner);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Ali");
        vet.setLastName("Baitas");

        vetService.save(vet);

        System.out.println(ownerService.findAll());
        System.out.println(vetService.findAll());
    }
}
