import dao.IDao;
import dao.configuracion.ConfiguracionJDBC;
import dao.impl.DomicilioDaoH2;
import dao.impl.OdontologoDaoH2;
import dao.impl.PacienteDaoH2;
import model.Domicilio;
import model.Odontologo;
import model.Paciente;
import service.DomicilioService;
import service.OdontologoService;
import service.PacienteService;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConfiguracionJDBC configuracionJDBC = new ConfiguracionJDBC();

        Domicilio domicilio = new Domicilio(1, "Calle", "3223", "Localidad",
                "Provincia");
        Paciente paciente = new Paciente(1, "Paciente", "prueba", "3333232424",
                Date.from(Instant.now()), domicilio);
        Odontologo odontologo = new Odontologo(1, "Medioc", "Odontologo",
                1253523);

        IDao<Odontologo> daoOdontologo = new OdontologoDaoH2(configuracionJDBC);
        OdontologoService odontologoService = new OdontologoService(daoOdontologo);
        odontologoService.registrarOdontologo(odontologo);

        DomicilioDaoH2 daoDomicilio = new DomicilioDaoH2();
        DomicilioService domicilioService = new DomicilioService(daoDomicilio);

        IDao<Paciente> daoPaciente = new PacienteDaoH2(daoDomicilio);
        PacienteService pacienteService = new PacienteService(daoPaciente);
    }
}
