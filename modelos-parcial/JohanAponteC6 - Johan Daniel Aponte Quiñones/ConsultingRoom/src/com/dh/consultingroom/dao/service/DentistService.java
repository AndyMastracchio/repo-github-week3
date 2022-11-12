package com.dh.consultingroom.dao.service;

import com.dh.consultingroom.dao.IDaoUsers;
import com.dh.consultingroom.model.Dentist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DentistService {

    private IDaoUsers<Dentist> dentistDao;

    public void saveDentist(Dentist dentist){
        dentistDao.save(dentist);
    }

    public void deleteDentist(int id){
        dentistDao.delete(id);
    }

    public Dentist searchDentist(int id){
        return dentistDao.search(id);
    }

    public List<Dentist> searchAllDentists(){
        return dentistDao.searchAll();
    }
}
