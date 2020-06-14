package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map Service Test")
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("First Before Each");
    }

    @Test
    @DisplayName("Verify Zero Owners")
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }

    @Nested
    @DisplayName("Pet Type Tests")
    class TestCreatePetTypes {
        @BeforeEach
        void setUp() {
            PetType dogPetType = new PetType(1L, "Dog");
            PetType catPetType = new PetType(2L, "Cat");
            petTypeService.save(dogPetType);
            petTypeService.save(catPetType);

            System.out.println("Nested Pet Type Before Each");
        }

        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();

            assertThat(petTypeCount).isEqualTo(2);
        }

        @Nested
        @DisplayName("Save Owner Tests")
        class SaveOwnersTests {
            @BeforeEach
            void setUp() {
                Owner owner = new Owner(100L, "Owner", "Pet");
                ownerMapService.save(owner);

                System.out.println("Nested Owner Before Each");
            }

            @Test
            void saveOwner() {
                Owner owner = new Owner(200L, "Owner", "Pet");

                Owner savedOwner = ownerMapService.save(owner);

                assertThat(savedOwner).isNotNull();
            }

            @Nested
            @DisplayName("Find Owner Tests")
            class FindOwnersTests {

                @Test
                @DisplayName("Find Owner")
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(100L);

                    assertThat(foundOwner).isNotNull();
                }

                @Test
                @DisplayName("Find Owner Not Found")
                void findOwnerNotFound() {
                    Owner notFoundOwner = ownerMapService.findById(200L);

                    assertThat(notFoundOwner).isNull();
                }
            }
        }
    }

    @Test
    @DisplayName("Verify Still Zero Owners")
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }
}