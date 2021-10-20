package za.ac.cput.ADP3LabBookingSystem.Repository;


import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;
import za.ac.cput.ADP3LabBookingSystem.Repository.IRepository;
import java.util.Set;

public interface IBookingRepository extends IRepository<Booking, String> {

    public Set<Booking> getAll();
}
