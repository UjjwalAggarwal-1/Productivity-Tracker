package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {

    public static String mysqlUser = "root";
    public static String mysqlPassword = "safemysql";
    private static String mysqlPort = "3306";
    private static String mysqlDatabase = "ProductivityTracker";
    public final static String CONNECTION = "jdbc:mysql://localhost:" +mysqlPort +"/" +mysqlDatabase;

    public static void save(String SQL){

        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(java.sql.Connection conn = DriverManager.getConnection(CONNECTION, mysqlUser, mysqlPassword);
            Statement statement = conn.createStatement()){
            statement.executeUpdate(SQL);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public static void createTable(String SQL){

        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(java.sql.Connection conn = DriverManager.getConnection(CONNECTION, mysqlUser, mysqlPassword);
            Statement statement = conn.createStatement()){
            statement.executeUpdate(SQL);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public static ResultSet retrieve(String Sql){

        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(java.sql.Connection conn = DriverManager.getConnection(CONNECTION, mysqlUser, mysqlPassword);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(Sql)){
           return resultSet;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
