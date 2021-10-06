/*
 * ComputerLabRepositoryTest.java
 * Test for the ComputerLabRepository.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 26 July 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Repository.ComputerLabRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Factory.ComputerLabFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ComputerLabRepositoryTest {
    public static ComputerLabRepository computerLabRepository = ComputerLabRepository.getComputerLabRepository();
    public static ComputerLab computerLab = ComputerLabFactory.createComputerLab("1.19", 35, true);

    @Test
    void a_create() {
        ComputerLab created = computerLabRepository.create(computerLab);
        assertEquals("1.19", computerLab.getLabId());
        System.out.println(created);
    }

    @Test
    void b_read() {
        ComputerLab read = computerLabRepository.read(computerLab.getLabId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        ComputerLab updated = new ComputerLab.Builder().copy(computerLab).setAvailability(false).build();
        assertNotNull(computerLabRepository.update(updated));
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        boolean deleted = computerLabRepository.delete(computerLab.getLabId());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    void d_getAll() {
        System.out.println("All computer labs:");
        System.out.println(computerLabRepository.getAll());
    }
}