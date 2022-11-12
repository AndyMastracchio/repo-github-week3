package service;



import dao.IDao;
import model.Paciente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p) throws SQLException, ClassNotFoundException {
        pacienteIDao.guardar(p);
        return p;
    }

    public Optional<Paciente> buscar(Integer id){
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }

    public void eliminar(Integer id){
         pacienteIDao.eliminar(id);
    }
}
