package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VetControllerTest {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet = new Vet(1L, "Joe", "Buck", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smiths", null);

        vetService.save(vet);
        vetService.save(vet2);
    }

    @Test
    void listVets() {

        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);
        assertThat("vets/index").isEqualTo(view);
        Set modelAttribute = (Set)  ((ModelMapImpl) model).getMap().get("vets");
        assertThat(modelAttribute).hasSize(2);

    }
}
