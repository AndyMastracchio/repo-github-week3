package service;

import dao.IDao;

import model.Odontologo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;


    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        return odontologoDao.guardar(odontologo);

    }

    public void eliminar(Integer id) {
        odontologoDao.eliminar(id);
    }

    public Optional<Odontologo> buscar(Integer id) {
        return odontologoDao.buscar(id);
    }

    public List<Odontologo> buscarTodos() {
        return odontologoDao.buscarTodos();
    }
}
