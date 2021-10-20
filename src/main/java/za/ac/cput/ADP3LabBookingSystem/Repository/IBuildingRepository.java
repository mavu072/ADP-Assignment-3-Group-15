package za.ac.cput.ADP3LabBookingSystem.Repository;

import za.ac.cput.ADP3LabBookingSystem.Entity.Building;

import java.util.Set;

public interface IBuildingRepository extends IRepository<Building, String> {
    Set<Building> getAll();
}
