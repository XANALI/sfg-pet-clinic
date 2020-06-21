package kz.xan.sfgpetclinic.service.map;

import kz.xan.sfgpetclinic.model.Speciality;
import kz.xan.sfgpetclinic.service.SpecialtiesService;

import java.util.Set;

public class SpecialtiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtiesService {

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
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
}
