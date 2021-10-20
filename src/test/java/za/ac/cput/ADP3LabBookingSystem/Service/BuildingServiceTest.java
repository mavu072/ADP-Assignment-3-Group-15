package za.ac.cput.ADP3LabBookingSystem.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.ADP3LabBookingSystem.Entity.Building;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Factory.BuildingFactory;
import za.ac.cput.ADP3LabBookingSystem.Factory.ComputerLabFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class BuildingServiceTest {

    @Autowired
    private BuildingService buildingService;

    private static Building building = BuildingFactory.createBuilding("Engineering");

    @Test
    void a_create() {
        Building createdBuilding = BuildingService.create(building);
        assertNotNull(createdBuilding);
        System.out.println("Created...");
        System.out.println("Building: " + createdBuilding);
    }

    @Test
    void b_read() {
        Building readBuilding = buildingService.read(Building.getBuildingId());
        assertNotNull(readBuilding);
        System.out.println("Read...");
        System.out.println("Building: " + readBuilding);
    }

    @Test
    void c_update() {
        Building oldBuilding = BuildingService.create(Building.getBuildingId());
        Building updatedBuilding = new Building.Builder().copy(oldBuilding).setBuildingId("Engineering").build();
        assertNotNull(BuildingService.update(updatedBuilding));
        System.out.println("Updated...");
        System.out.println("Computer Lab: " + updatedBuilding);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean isDeleted = BuildingService.delete("Engineering");
        assertTrue(isDeleted);
        System.out.println("Deleted: " + isDeleted);
    }

    @Test
    void d_getAll() {
        List<Building> BuildingList = (List<Building>) BuildingService.getAll();
        BuildingList.forEach( computerLab -> System.out.println("Building: " + building));
    }
}