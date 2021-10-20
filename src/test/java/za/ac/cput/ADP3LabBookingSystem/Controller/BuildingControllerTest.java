package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.Building;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Factory.BuildingFactory;
import za.ac.cput.ADP3LabBookingSystem.Factory.ComputerLabFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BuildingControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8090/building";


    private final String username = "admin";
    private final String password = "admin1234";

    private static Building building = BuildingFactory.createBuilding("Engineering");
    private Object Building;

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Building> postResponse = testRestTemplate.postForEntity(url, building, Building.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Building = postResponse.getBody();
        System.out.println("Saved data: " + Building);
        assertEquals(za.ac.cput.ADP3LabBookingSystem.Entity.Building.getBuildingId(), postResponse.getBody().getBuildingId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + Building;
        ResponseEntity<Building> responseEntity = testRestTemplate.getForEntity(url, Building.class);
        assertNotNull(responseEntity);
        System.out.println("Read data: " + responseEntity.getBody());
        assertEquals(za.ac.cput.ADP3LabBookingSystem.Entity.Building.getBuildingId(), responseEntity.getBody().getBuildingId());
    }

    @Test
    void c_update() {
        Building updatedBuilding = new ComputerLab.Builder().copy(za.ac.cput.ADP3LabBookingSystem.Entity.Building.getBuildingId().build());

        String url = baseURL + "/update";
        ResponseEntity<Building> responseEntity = testRestTemplate.postForEntity(url, updatedBuilding, Building.class);
        assertNotNull(responseEntity);
        System.out.println("Updated data: " + responseEntity.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + za.ac.cput.ADP3LabBookingSystem.Entity.Building.getBuildingId();
        ResponseEntity<Building> responseEntity = testRestTemplate.getForEntity(baseURL + "/read/" + za.ac.cput.ADP3LabBookingSystem.Entity.Building.getBuildingId(), Building.class);
        assertNotNull(responseEntity.getBody().getBuildingId(), "Building id{'" + za.ac.cput.ADP3LabBookingSystem.Entity.Building.getBuildingId() + "'} was not found.");
        testRestTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Read all...");
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }
}