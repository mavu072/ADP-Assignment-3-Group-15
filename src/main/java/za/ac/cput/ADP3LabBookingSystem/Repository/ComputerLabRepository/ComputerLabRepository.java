/*
 * ComputerLabRepository.java
 * ComputerLabRepository class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 26 July 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Repository.ComputerLabRepository;

import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class ComputerLabRepository implements IRepository<ComputerLab, String> {
    private static ComputerLabRepository computerLabRepository = null;
    private Set<ComputerLab> computerLabDB = null;

    private ComputerLabRepository() {
        computerLabDB = new HashSet<ComputerLab>();
    }

    public static ComputerLabRepository getComputerLabRepository() {
        if (computerLabRepository == null) {
            computerLabRepository = new ComputerLabRepository();
        }
        return computerLabRepository;
    }

    //create
    @Override
    public ComputerLab create(ComputerLab lab) {
        boolean created = computerLabDB.add(lab);
        if (!created) {
            return null;
        }
        return lab;
    }

    //read
    @Override
    public ComputerLab read(String labId) {
        for (ComputerLab lab : computerLabDB)
            if (lab.getLabId().equals(labId)) {
                return lab;
            }
        return null;
    }

    //update
    @Override
    public ComputerLab update(ComputerLab lab) {
        ComputerLab oldLab = read(lab.getLabId());
        if (oldLab != null) {
            computerLabDB.remove(oldLab);
            computerLabDB.add(lab);
        }
        return lab;
    }

    //delete
    @Override
    public boolean delete(String labId) {
        ComputerLab labToDelete = read(labId);
        if (labToDelete == null)
            return false;
        computerLabDB.remove(labToDelete);
        return true;
    }

    //getAll
    @Override
    public Set<ComputerLab> getAll() {
        return computerLabDB;
    }
}
