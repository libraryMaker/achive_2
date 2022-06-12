import java.sql.*;

public class DataBase {

    private static final String url = "jdbc:mysql://localhost:3306/ACHIVE";
    private static final String user = "root";
    private static final String password = "746Td215";

    private static Connection con;

    public static String callDBProc(int value) {
    String param = "Something went wrong";
    try {
        // opening database connection to MySQL server
        con = DriverManager.getConnection(url, user, password);
        CallableStatement proc = con.prepareCall("{? = call ACHIVE.addNumber(?)}");
        proc.registerOutParameter(1, Types.VARCHAR);
        proc.setInt(2, value);
        // Step-5: execute the stored procedures: proc3

        proc.execute();
        // Step-6: extract the output parameters
        param = proc.getString(1);
        return param;
    } catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    } finally {
        //close connection ,stmt and resultset here
        try { con.close();
              return param;
        } catch(SQLException se) {}
    }

    return param;

}
}
