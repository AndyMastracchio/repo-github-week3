package service;

import dao.IDaoMedicamento;
import dao.impl.MedicamentoDaoH2;
import model.Medicamento;

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
