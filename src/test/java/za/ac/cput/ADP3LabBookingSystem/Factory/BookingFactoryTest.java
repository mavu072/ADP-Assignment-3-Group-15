/*
   BookingFactoryTest.java
   Booking Factory Test
   Author: AJ Mitchell 219024979
   Date: 10 June
*/

package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.Test;

class BookingFactoryTest {

    @Test
    public static void demo(){
        BookingFactory bf = new BookingFactory();
        System.out.println(bf.getBooking());

        
    }


}