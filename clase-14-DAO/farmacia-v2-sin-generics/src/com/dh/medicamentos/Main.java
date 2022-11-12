package com.dh.medicamentos;

import com.dh.medicamentos.dao.IDaoMedicamento;
import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;
import com.dh.medicamentos.service.MedicamentoService;

public class Main {

    public static void main(String[] args) {
        IDaoMedicamento dao = new MedicamentoDaoH2();
        MedicamentoService service = new MedicamentoService();
        Medicamento medicamento = new Medicamento("Medkit", "Labz", 50, 350.0);
        service.guardar(medicamento);

    }
}
