package dao.impl;

import dao.IDao;
import dao.configuracion.ConfiguracionJDBC;
import model.Domicilio;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DomicilioDaoH2 implements IDao<Domicilio> {
    private ConfiguracionJDBC configuracionJDBC;

    public DomicilioDaoH2() {
        this.configuracionJDBC = new ConfiguracionJDBC();
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES('%s','%s','%s','%s')", domicilio.getCalle(),
                domicilio.getNumero(), domicilio.getLocalidad(), domicilio.getProvincia());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
           ResultSet keys = stmt.getGeneratedKeys();
           if(keys.next())
               domicilio.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return domicilio;
    }

    @Override
    public Optional<Domicilio> buscar(Integer id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = '%s'", id);
        Domicilio domicilio = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                domicilio = crearObjetoDomicilio(result);
            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  domicilio != null ? Optional.of(domicilio) : Optional.empty();
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("DELETE FROM domicilios where id = %s", id);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = "SELECT *  FROM domicilios";
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                domicilios.add(crearObjetoDomicilio(result));

            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return domicilios;
    }

    private Domicilio crearObjetoDomicilio(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        String calle = result.getString("calle");
        String numero = result.getString("numero");
        String localidad = result.getString("localidad");
        String provincia = result.getString("provincia");
        return new Domicilio(id, calle, numero, localidad, provincia);

    }
}
