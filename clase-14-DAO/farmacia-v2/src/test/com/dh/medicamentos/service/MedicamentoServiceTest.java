package test.com.dh.medicamentos.service;

import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;
import com.dh.medicamentos.service.MedicamentoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicamentoServiceTest {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());

    @Test
    public  void guardarMedicamento(){
        Medicamento medicamento = new Medicamento("Ibuprofeno", "lab123", 1000, 200.0);
        medicamentoService.guardar(medicamento);
        assertTrue(medicamentoService.buscar(1) != null);

    }
    @Test
    public void traerPorId(){
        Medicamento medicamento = medicamentoService.buscar(1);
        //assertTrue(medicamento != null);
        assertFalse(medicamento == null);
    }
}
