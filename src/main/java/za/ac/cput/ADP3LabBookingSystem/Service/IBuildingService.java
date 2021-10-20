package za.ac.cput.ADP3LabBookingSystem.Service;

import za.ac.cput.ADP3LabBookingSystem.Entity.Building;

import java.util.Set;

public interface IBuildingService extends IService<Building, String >{
    Set<Building> getAll();
}
