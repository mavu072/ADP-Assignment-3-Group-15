package za.ac.cput.ADP3LabBookingSystem.Repository;

import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;
import za.ac.cput.ADP3LabBookingSystem.Repository.IBookingRepository;
import java.util.HashSet;
import java.util.Set;


public class BookingRepository implements IBookingRepository{

    private static BookingRepository repository = null;
    private Set<Booking> bookingDB = null;

    private BookingRepository(){
        bookingDB = new HashSet<Booking>();
    }

    public static BookingRepository getInstance(){
        if(repository == null){
            repository = new BookingRepository();
        }
        return repository;
    }

    @Override
    public Booking create(Booking booking) {
        boolean created = bookingDB.add(booking);
        if(!created) return null;
        return booking;
    }

    @Override
    public Booking read(String bookingId) {

        for(Booking b : bookingDB){
            if (b.getBookingId().equals(bookingId)){
                return b;
            }
        }
        return null;
    }

    @Override
    public Booking update(Booking booking) {

        Booking oldBookingObj = read(booking.getBookingId());
        if (oldBookingObj != null) {
            bookingDB.remove(oldBookingObj);
            bookingDB.add(booking);
            return booking;
        }
        return null;
    }

    @Override
    public boolean delete(String bookingId) {

        Booking bookingToDelete = read(bookingId);
        if (bookingToDelete == null) return false;

        bookingDB.remove(bookingToDelete);
        return true;
    }


    @Override
    public Set<Booking> getAll() {
        return bookingDB;
    }

}

