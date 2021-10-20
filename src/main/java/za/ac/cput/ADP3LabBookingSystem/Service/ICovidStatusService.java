package za.ac.cput.ADP3LabBookingSystem.Service;

import za.ac.cput.ADP3LabBookingSystem.Entity.CovidStatus;

import java.util.List;

public interface ICovidStatusService extends IService<CovidStatus, String>{
    public List<CovidStatus> getAll();
}
