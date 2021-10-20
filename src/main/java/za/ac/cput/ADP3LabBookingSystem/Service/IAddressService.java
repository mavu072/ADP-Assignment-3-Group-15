package za.ac.cput.ADP3LabBookingSystem.Service;

import za.ac.cput.ADP3LabBookingSystem.Entity.Address;

import java.util.List;

public interface IAddressService extends IService {

    public List<Address> getAll();

    //TODO public List<Address> getAllByZipCode();
    //TODO public List<ComputerLab> getAllByStreet();
    //TODO public List<ComputerLab> getAllByCi
}
