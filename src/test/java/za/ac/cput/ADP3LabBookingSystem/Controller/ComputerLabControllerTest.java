/*
 * ComputerLabControllerTest.java
 * ComputerLabController test class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 10 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Factory.ComputerLabFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComputerLabControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8080/computerlab";

    private static ComputerLab computerLab = ComputerLabFactory.createComputerLab("2.34", "20002", 120, true);

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<ComputerLab> postResponse = testRestTemplate.postForEntity(url, computerLab, ComputerLab.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        computerLab = postResponse.getBody();
        System.out.println("Saved data: " + computerLab);
        assertEquals(computerLab.getLabId(), postResponse.getBody().getLabId());
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}