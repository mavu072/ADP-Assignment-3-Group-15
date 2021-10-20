package za.ac.cput.ADP3LabBookingSystem.Repository;

import za.ac.cput.ADP3LabBookingSystem.Entity.Building;


import java.util.HashSet;
import java.util.Set;

public class BuildingRepository implements IBuildingRepository {

    private static BuildingRepository repository = null;
    private Set<Building> buildingDS = null;

    private BuildingRepository(){
        buildingDS = new HashSet<Building>();
    }

    public static BuildingRepository getRepository(){
        if(repository == null){
            repository = new BuildingRepository();
        }
        return repository;
    }

    @Override
    public Building create(Building building) {
        boolean success = buildingDS.add(building);
        if(!success)
            return null;
        return building;
    }

    @Override
    public Building read(String buildingId) {
        for (Building e: buildingDS)
            if(e.getBuildingId().equalsIgnoreCase(buildingId)){
                return e;
            }
        return null;
    }

    @Override
    public Building update(Building building) {
        Building oldBuilding = read(building.getBuildingId());
        if(oldBuilding != null){
            buildingDS.remove(oldBuilding);
            buildingDS.add(building);
            return building;
        }
        return null;
    }

    @Override
    public boolean delete(String buildingId) {
        Building buildingRemoved = read(buildingId);
        if(buildingRemoved == null)
            return false;
        buildingDS.remove(buildingRemoved);
        return true ;
    }

    @Override
    public Set<Building> getAll() {
        return buildingDS;
    }
}
