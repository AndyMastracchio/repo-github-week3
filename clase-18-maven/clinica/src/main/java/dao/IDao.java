package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    public T guardar(T t) throws ClassNotFoundException, SQLException;
    public Optional<T> buscar(Integer id);
    public void eliminar(Integer id);
    public List<T> buscarTodos();

}
