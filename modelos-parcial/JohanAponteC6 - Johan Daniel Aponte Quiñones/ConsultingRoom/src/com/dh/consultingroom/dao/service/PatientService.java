package com.dh.consultingroom.dao.service;

import com.dh.consultingroom.dao.IDaoUsers;
import com.dh.consultingroom.model.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents a layer which has the responsibility of disengage
 * data layer from view layer
 * @author Aponte
 */
@Getter
@Setter
public class PatientService {

    private IDaoUsers<Patient> patientDao;

    public void savePatient(Patient patient){
        patientDao.save(patient);
    }

    public void deletePatient(int id){
        patientDao.delete(id);
    }

    public Patient searchPatient(int id){
        return patientDao.search(id);
    }

    public List<Patient> searchAllPatients(){
        return patientDao.searchAll();
    }
}
