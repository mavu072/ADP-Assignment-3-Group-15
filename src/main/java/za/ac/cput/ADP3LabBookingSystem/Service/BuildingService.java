package za.ac.cput.ADP3LabBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ADP3LabBookingSystem.Entity.Building;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Repository.BuildingRepository;
import za.ac.cput.ADP3LabBookingSystem.Repository.ComputerLabRepository;

import java.util.List;
import java.util.Set;

@Service
public class BuildingService implements IBuildingService {
    private static BuildingService service = null;

    @Autowired
    private BuildingRepository repository;

    @Override
    public Building create(Building building) {
        return this.repository.create(building);
    }

    @Override
    public Building read(String buildingId) {
        return this.repository.read(buildingId);
    }

    @Override
    public Building update(Building building) {
        return  this.repository.update(building);

    }

    @Override
    public boolean delete(String buildingId) {
        return this.repository.delete(buildingId);

    }

    @Override
    public Set<Building> getAll() {
        return this.repository.getAll();
    }
}

