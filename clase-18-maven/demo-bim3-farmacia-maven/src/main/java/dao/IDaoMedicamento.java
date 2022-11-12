package dao;

import model.Medicamento;

public interface IDaoMedicamento{

    public Medicamento guardar(Medicamento medicamento);
    public Medicamento buscar(Integer id);
}
