package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialityMapService specialityMapService;

    VetController vetController;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        vetService = new VetMapService(specialityMapService);

        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "John", "Buck", new HashSet<>());
        Vet vet2 = new Vet(2L, "Mark", "Campbell", new HashSet<>());

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelImpl();

        String view = vetController.listVets(model);

        assertThat(view).isEqualTo("vets/index");

        Set<Vet> vets = (Set<Vet>) ((ModelImpl) model).getMap().get("vets");
        assertThat(vets.size()).isEqualTo(2);
    }
}