package za.ac.cput.ADP3LabBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ADP3LabBookingSystem.Entity.Address;
import za.ac.cput.ADP3LabBookingSystem.Repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    private static AddressService service = null;

    @Autowired
    private AddressRepository repository;

    @Override
    public Address create(Address address){
        return this.repository.save(address);
    }

    @Override
    public Address read(String zipCode){
        return this.repository.findById(zipCode).orElse(null);
    }

    @Override
    public Address update(Address address){
        if (this.repository.existById(address.getZipCode()));
        return this.repository.save(address);
    }

    public boolean delete(int zipCode) {
        this.repository.deleteById(zipCode);

        if (this.repository.existsById(zipCode))
            return false;
        else
            return true;
    }
    @Override
    public List<Address> getAll() {
        return this.repository.findAll();

    }

}
