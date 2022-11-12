import dao.IDaoMedicamento;
import dao.impl.MedicamentoDaoH2;
import model.Medicamento;
import service.MedicamentoService;


public class Main {

    public static void main(String[] args) {
        IDaoMedicamento dao = new MedicamentoDaoH2();
        MedicamentoService service = new MedicamentoService();
        Medicamento medicamento = new Medicamento("Medkit", "Labz", 50, 350.0);
        service.guardar(medicamento);

    }
}
