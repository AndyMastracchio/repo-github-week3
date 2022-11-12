package com.dh.medicamentos.dao;

import com.dh.medicamentos.model.Medicamento;

public interface IDaoMedicamento{

    public Medicamento guardar(Medicamento medicamento);
    public Medicamento buscar(Integer id);
}
