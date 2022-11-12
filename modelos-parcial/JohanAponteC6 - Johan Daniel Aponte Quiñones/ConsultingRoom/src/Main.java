import com.dh.consultingroom.connection.DatabaseConnection;
import com.dh.consultingroom.dao.impl.DentistDaoH2Impl;
import com.dh.consultingroom.dao.impl.PatientDaoH2Impl;
import com.dh.consultingroom.dao.service.DentistService;
import com.dh.consultingroom.dao.service.PatientService;
import com.dh.consultingroom.dbtransactions.DbTransactions;
import com.dh.consultingroom.model.Dentist;
import com.dh.consultingroom.model.Patient;
import com.dh.consultingroom.model.User;
import com.dh.consultingroom.model.Role;
import com.dh.consultingroom.usersflyweight.UserFlyweight;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //Objects instances
        User paciente1 = UserFlyweight.getUserInstance("Filomeno", "Aponte", "1013666999", Role.USER);
        paciente1.setMail("usuario1@gmail.com");
        paciente1.setPhone("3222730000");

        User paciente2 = UserFlyweight.getUserInstance("Jorg", "Gómez", "1013777101", Role.USER);
        paciente2.setMail("usuario2@gmail.com");
        paciente2.setPhone("3222731111");

        User paciente3 = UserFlyweight.getUserInstance("John", "Aponte", "1013555888", Role.USER);
        paciente3.setMail("usuario3@gmail.com");
        paciente3.setPhone("3222732222");

        User dentista1 = UserFlyweight.getUserInstance("Daniel", "Quiñones", "1013111444", Role.ADMIN);
        dentista1.setMail("dentista1@gmail.com");
        dentista1.setPhone("3222733333");

        User dentista2 = UserFlyweight.getUserInstance("Kevin", "Forero", "1013222555", Role.ADMIN);
        dentista2.setMail("dentista2@gmail.com");
        dentista2.setPhone("3222734444");

        User dentista3 = UserFlyweight.getUserInstance("Manuel", "Cabezas", "1013000333", Role.ADMIN);
        dentista3.setMail("dentista3@gmail.com");
        dentista3.setPhone("3222735555");

        UserFlyweight.usersStorage.forEach((key, value) ->
                LOGGER.info(value)
        );

        try {
            createTable(DatabaseConnection.getInstance().getConnection(),
                    DbTransactions.CREATE_TABLE_PATIENT.getTransactionType(),
                    DbTransactions.CREATE_TABLE_DENTIST.getTransactionType()
            );
        } catch (SQLException e) {
            LOGGER.error("Exception: " + e);
        }

        PatientService patientService = new PatientService();
        patientService.setPatientDao(new PatientDaoH2Impl());

        DentistService dentistService = new DentistService();
        dentistService.setDentistDao(new DentistDaoH2Impl());

        UserFlyweight.usersStorage.forEach((key, value) ->{
            if (value.getRole().getRole().equals("ROLE_USER")) {
                patientService.savePatient((Patient) value);
            } else {
                dentistService.saveDentist((Dentist) value);
            }
        });

        dentistService.deleteDentist(1);

        ArrayList<Patient> patients = (ArrayList<Patient>) patientService.searchAllPatients();
        LOGGER.info("Info gotten from Data Base:\n" + Collections.singletonList(patients));

        System.out.println(UserFlyweight.getUserByDni("10136566999"));

    }

    public static void createTable(Connection connection, String ...transactions) throws SQLException {

        Arrays.stream(transactions).forEach(transaction -> {
            try {
                connection.createStatement().execute(transaction);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

    }


}