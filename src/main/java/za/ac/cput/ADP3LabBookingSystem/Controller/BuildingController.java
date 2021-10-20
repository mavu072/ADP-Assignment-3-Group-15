package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.Building;
import za.ac.cput.ADP3LabBookingSystem.Factory.BuildingFactory;
import za.ac.cput.ADP3LabBookingSystem.Service.BuildingService;


import java.util.Set;
@RestController
@RequestMapping ("/building")


public class BuildingController {

    @Autowired
    private BuildingService service;

    @PostMapping("/create")
//public String create(ClientAccount clientAccount)
//    {
//        return "account created";
//    }

    public Building create(@RequestBody Building BuildingId) {
        Building newBuilding = BuildingFactory.createBuilding(BuildingId.getBuildingId());
        return service.create(newBuilding);
    }

    @GetMapping("/read")
    public Building read(@RequestBody Building building) {
        return service.read(building.getBuildingId());
    }

    @PostMapping("/update")
    public Building update(@RequestBody Building building) {
        return service.update(building);
    }

    @DeleteMapping("/delete/{buildingId}")
    public boolean delete(@PathVariable String buildingId) {
        return service.delete(buildingId);
    }
}
