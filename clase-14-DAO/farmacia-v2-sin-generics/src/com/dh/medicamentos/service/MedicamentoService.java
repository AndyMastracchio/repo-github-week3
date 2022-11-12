package com.dh.medicamentos.service;

import com.dh.medicamentos.dao.IDaoMedicamento;
import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;

public class MedicamentoService {

    private IDaoMedicamento medicamentoDao;

    public MedicamentoService() {
        // Instancio la implementación que quiero usar.
        // Si hubiese una implementación MedicamentoDaoMySql,
        // debería elegir cuál instanciar, por ejemplo
        this.medicamentoDao = new MedicamentoDaoH2();
    }

    public Medicamento guardar(Medicamento medicamento){
       return medicamentoDao.guardar(medicamento);

    }

    public  Medicamento buscar(Integer id){
        return medicamentoDao.buscar(id);
    }
}
