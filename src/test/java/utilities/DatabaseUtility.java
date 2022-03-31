package utilities;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.testng.Assert;

import java.sql.*;

public class DatabaseUtility {

    private static String connectionURL = FileUtility.getProperty("config", "CONNECTION_URL_STAGE");
    private Connection con;

    //TO DO
    public Connection getConnection(){
        String jumpserverUsername = "ssh paymentsteam";
        String jumpserverPassword = "payments@123";
        String jumpserverHost = "10.20.15.26";
        try {
            String databaseHost = connectionURL;
            int databasePort = 3306;
            String databaseUsername;
            String databasePassword = "mbk@123";
            String database = "mobinew";
            JSch jsch = new JSch();
            Session session = jsch.getSession(jumpserverUsername, jumpserverHost);
            session.setPassword(jumpserverPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig("PreferredAuthentications", "password");
            System.out.println("Establishing Connection...");
            session.connect();
            int forwardedPort = session.setPortForwardingL(0, databaseHost, databasePort);
            con = DriverManager.getConnection(databaseHost, "", databasePassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return con;
    }


    public String selectPreparedStatement(Connection con, String cell){
        ResultSet resultSet = null; String result = null;
        Assert.assertNotNull(con, "Can't create connection");
        String strQuery = FileUtility.getProperty("query", cell);
        if(strQuery.contains("ABC")){
            try {
                PreparedStatement ps = con.prepareStatement(strQuery.replace("ABC", cell));
                resultSet = ps.executeQuery();
                if (resultSet.next()){
                    result = resultSet.getString("o");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //execute single row
    public String fetchSingleData(String queryName, String param){
        ResultSetMetaData rsmd = null;
        Connection con = getConnection();
        String ps = selectPreparedStatement(con, param);
        return ps;
    }

}
