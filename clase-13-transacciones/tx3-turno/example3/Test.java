package z.com.example3;

import java.sql.*;

public class Test {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS HORA; CREATE TABLE TURNO "
                                                    + "("
                                                    + " ID INT PRIMARY KEY,"
                                                    + " HORA varchar(100) NOT NULL, "
                                                    + " DIA INT NOT NULL"
                                                    + " )";

    private static final String SQL_INSERT =  "INSERT INTO TURNO (ID, HORA, DIA) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE =  "UPDATE TURNO SET DIA=? WHERE ID=?";

    public static void main(String[] args) throws Exception {
        Turno turno = new Turno("12:25", 21);

        Connection connection = null;

        try {
            connection= getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, turno.getHora());
            psInsert.setInt(3, turno.getDia());

            psInsert.execute();
            connection.setAutoCommit(false);

            PreparedStatement psUpdate1 = connection.prepareStatement(SQL_UPDATE);
            psUpdate1.setInt(1, turno.getDia() + 2);
            psUpdate1.setInt(2, 1);
            psUpdate1.execute();


            connection.setAutoCommit(true);

            String sql = "SELECT * FROM TURNO";
            Statement sqlSmt = connection.createStatement();
            ResultSet rs = sqlSmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getInt(3));
            }


        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }


    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test");

    }

}
