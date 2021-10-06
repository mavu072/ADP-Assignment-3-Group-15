/*
 * GenericHelper.java
 * GenericHelper Class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 10 June 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Util;

import java.util.UUID;

public class GenericHelper {

    //buildingId
    public static String generateBuildingId() {

        return UUID.randomUUID().toString();
    }

}
