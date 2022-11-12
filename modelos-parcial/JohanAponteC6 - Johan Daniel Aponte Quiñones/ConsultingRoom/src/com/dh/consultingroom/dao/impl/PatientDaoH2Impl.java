package com.dh.consultingroom.dao.impl;

import com.dh.consultingroom.connection.DatabaseConnection;
import com.dh.consultingroom.dao.IDaoUsers;
import com.dh.consultingroom.dbtransactions.DbTransactions;
import com.dh.consultingroom.model.Patient;
import com.dh.consultingroom.model.Role;
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
public class PatientDaoH2Impl implements IDaoUsers<Patient> {

    @Override
    public void save(Patient patient) {

        PreparedStatement preparedStatement;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DbTransactions.INSERT_IN_PATIENT.getTransactionType());
            preparedStatement.setInt(1, patient.getId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setString(4, patient.getMail());
            preparedStatement.setString(5, patient.getPhone());
            preparedStatement.setString(6, patient.getDni());
            preparedStatement.setString(7, patient.getRole().getRole());

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
            preparedStatement = connection.prepareStatement(DbTransactions.DELETE_PATIENT.getTransactionType());
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Patient search(int id) {

        Patient patient = null;
        PreparedStatement preparedStatement;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DbTransactions.SEARCH_ONE_PATIENT.getTransactionType());
            preparedStatement.setInt(1, 1);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                patient = getPatientInfo(resultSet);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public List<Patient> searchAll() {
        Patient patient;
        ArrayList<Patient> patientsList = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DbTransactions.SEARCH_ALL_PATIENTS.getTransactionType());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                patient = getPatientInfo(resultSet);
                patientsList.add(patient);
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
    private static Patient getPatientInfo(ResultSet resultSet) throws SQLException {
        Patient patient;
        int idPatient = resultSet.getInt("ID");
        String namePatient = resultSet.getString("NAME");
        String lastNamePatient = resultSet.getString("LASTNAME");
        String mailPatient = resultSet.getString("MAIL");
        String phonePatient = resultSet.getString("PHONE");
        String dniPatient = resultSet.getString("DNI");
        String rolePatient = resultSet.getString("ROLE");

        patient = new Patient();
        patient.setId(idPatient);
        patient.setName(namePatient);
        patient.setLastName(lastNamePatient);
        patient.setMail(mailPatient);
        patient.setPhone(phonePatient);
        patient.setDni(dniPatient);
        if (rolePatient.equals("ROLE_USER")) {
            patient.setRole(Role.USER);
        } else {
            patient.setRole(Role.ADMIN);
        }
        return patient;
    }
}
