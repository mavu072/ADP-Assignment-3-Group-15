package za.ac.cput.ADP3LabBookingSystem.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;
import za.ac.cput.ADP3LabBookingSystem.Repository.BookingRepository;

import java.util.Set;

@Service
public class BookingService implements IBookingService{
    private static BookingService service = null;
    private BookingRepository repository = null;

    private BookingService(){this.repository = BookingRepository.getInstance();}

    //
    public static BookingService getService(){
        if(service == null){
            service = new BookingService();
        }
        return service;
    }

    @Override
    public Booking create(Booking booking) {

        return this.repository.create(booking);
    }

    @Override
    public Booking read(String bookingId) {
        return this.repository.read(bookingId);
    }

    @Override
    public Booking update(Booking booking) {

        return this.repository.update(booking);
    }

    @Override
    public boolean delete(String bookingId) {

        return this.repository.delete(bookingId);
    }

    @Override
    public Set<Booking> getAll() {
        return null;
    }
}

