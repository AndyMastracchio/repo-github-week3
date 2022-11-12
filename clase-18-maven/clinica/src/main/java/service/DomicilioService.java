package service;


import dao.IDao;
import model.Domicilio;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DomicilioService {
    private IDao<Domicilio> domicilioDao;

    public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    public Domicilio guardar(Domicilio d) throws SQLException, ClassNotFoundException {
        domicilioDao.guardar(d);
        return d;
    }

    public Optional<Domicilio> buscar(Integer id){
        return domicilioDao.buscar(id);
    }

    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }

    public void eliminar(Integer id){
        domicilioDao.eliminar(id);
    }

}
