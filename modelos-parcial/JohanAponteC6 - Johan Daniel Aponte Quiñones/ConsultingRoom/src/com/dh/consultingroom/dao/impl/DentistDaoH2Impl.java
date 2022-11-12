package com.dh.consultingroom.dao.impl;

import com.dh.consultingroom.connection.DatabaseConnection;
import com.dh.consultingroom.dao.IDaoUsers;
import com.dh.consultingroom.dbtransactions.DbTransactions;
import com.dh.consultingroom.model.Dentist;
import com.dh.consultingroom.model.Patient;
import com.dh.consultingroom.model.Role;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements a DAO interface to operate with a particular DB
 * @author Aponte
 */
public class DentistDaoH2Impl implements IDaoUsers<Dentist> {

    private static final Logger LOGGER = Logger.getLogger(DentistDaoH2Impl.class);
    @Override
    public void save(Dentist dentist) {
        LOGGER.info("Saving Dentist");
        PreparedStatement preparedStatement;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DbTransactions.INSERT_IN_DENTIST.getTransactionType());
            preparedStatement.setInt(1, dentist.getId());
            preparedStatement.setString(2, dentist.getName());
            preparedStatement.setString(3, dentist.getLastName());
            preparedStatement.setString(4, dentist.getMail());
            preparedStatement.setString(5, dentist.getPhone());
            preparedStatement.setString(6, dentist.getDni());
            preparedStatement.setString(7, dentist.getRole().getRole());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DbTransactions.DELETE_DENTIST.getTransactionType());
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dentist search(int id) {
        Dentist dentist = null;
        PreparedStatement preparedStatement;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DbTransactions.SEARCH_ONE_DENTIST.getTransactionType());
            preparedStatement.setInt(1, 1);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dentist = getDentistInfo(resultSet);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dentist;
    }

    @Override
    public List<Dentist> searchAll() {
        Dentist dentist;
        ArrayList<Dentist> patientsList = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DbTransactions.SEARCH_ALL_DENTIST.getTransactionType());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dentist = getDentistInfo(resultSet);
                patientsList.add(dentist);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patientsList;
    }

    /**
     * Return an object structure with the DB information
     * @param resultSet set of tuples to be deserialized
     * @return Patient each tuple information
     * @throws SQLException if anything went wrong
     * @author Aponte
     */
    @NotNull
    private static Dentist getDentistInfo(ResultSet resultSet) throws SQLException {
        Dentist dentist;
        int idDentist = resultSet.getInt("ID");
        String nameDentist = resultSet.getString("NAME");
        String lastNameDentist = resultSet.getString("LASTNAME");
        String mailDentist = resultSet.getString("MAIL");
        String phoneDentist = resultSet.getString("PHONE");
        String dniDentist = resultSet.getString("DNI");
        String roleDentist = resultSet.getString("ROLE");

        dentist = new Dentist();
        dentist.setId(idDentist);
        dentist.setName(nameDentist);
        dentist.setLastName(lastNameDentist);
        dentist.setMail(mailDentist);
        dentist.setPhone(phoneDentist);
        dentist.setDni(dniDentist);
        if (roleDentist.equals("ROLE_ADMIN")) {
            dentist.setRole(Role.ADMIN);
        } else {
            dentist.setRole(Role.USER);
        }
        return dentist;
    }
}
