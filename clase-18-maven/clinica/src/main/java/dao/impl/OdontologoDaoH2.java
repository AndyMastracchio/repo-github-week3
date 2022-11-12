package dao.impl;

import dao.IDao;
import dao.configuracion.ConfiguracionJDBC;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private ConfiguracionJDBC configuracionJDBC;
    final static Logger log = Logger.getLogger(OdontologoDaoH2.class);

    public OdontologoDaoH2(ConfiguracionJDBC configuracionJDBC) {
        this.configuracionJDBC = new ConfiguracionJDBC();
    }

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db-clinica;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="root";
    private final static String DB_PASSWORD = "";

    @Override
    public Odontologo guardar(Odontologo odontologo) throws ClassNotFoundException, SQLException {
        log.debug("Registrando nuevo odontologo : "+ odontologo.toString());
        Class.forName(DB_JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt = null;
        String query = String.format("INSERT INTO odontologos(nombre,apellido,matricula) VALUES('%s','%s','%s')", odontologo.getNombre(), odontologo.getApellido(),
                odontologo.getMatricula());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                odontologo.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return odontologo;
    }

    @Override
    public Optional<Odontologo> buscar(Integer id) {
        log.debug("Buscando odontologo con id : "+id);
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("SELECT id,nombre,apellido,matricula FROM odontologos where id = '%s'", id);
        Odontologo odontologo = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                odontologo = crearObjetoOdontologo(result);
            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo != null ? Optional.of(odontologo) : Optional.empty();
    }

    @Override
    public void eliminar(Integer id) {
        log.debug("Borrand odontologo con id : "+id);
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("DELETE FROM odontologos where id = %s", id);
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
    public List<Odontologo> buscarTodos() {
        log.debug("Buscando todos los odontologos");
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = "SELECT *  FROM odontologos";
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                odontologos.add(crearObjetoOdontologo(result));

            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return odontologos;
    }

    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {

        return new Odontologo(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("matricula"));
    }
}
