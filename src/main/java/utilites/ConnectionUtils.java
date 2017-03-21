package utilites;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtils {
    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;

    public static Properties getProperties(){
        FileInputStream fileInputStream;
        Properties property = new Properties();
        String path = "C:/Users/Dimon/IdeaProjects/Maven/src/main/resources/jdbc.properties";

        try {
            fileInputStream = new FileInputStream(path);
            property.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public static void connectionToDataBase(Properties properties) throws SQLException, ClassNotFoundException{
//        Driver driver = new FabricMySQLDriver();
//        DriverManager.registerDriver(driver);
        String driver = properties.getProperty("jdbc.driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
    }

    public static void closeConnection()throws SQLException{
        connection.close();
    }

    public static void closeStatement()throws SQLException{
        statement.close();
    }

    public static void closePrepearedStatement()throws SQLException{
        preparedStatement.close();
    }

    public static PreparedStatement preparedStatementCreateDelete(String nameMethod, String whereName)throws SQLException,
            ClassNotFoundException{
        connectionToDataBase(getProperties());
        preparedStatement = connection.prepareStatement(nameMethod);
        preparedStatement.setString(1, whereName);
        preparedStatement.executeUpdate();
        return preparedStatement;
    }
    public static PreparedStatement preparedStatementUpdate(String nameMethod, String otherName, String whereName)throws
            SQLException, ClassNotFoundException{
        connectionToDataBase(getProperties());
        preparedStatement = connection.prepareStatement(nameMethod);
        preparedStatement.setString(1, otherName);
        preparedStatement.setString(2, whereName);
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

 //  public static PreparedStatement preparedStatementDelete(String nameMethod, String whereName)throws SQLException,
 //          ClassNotFoundException{
 //      connectionToDataBase(getProperties());
 //      preparedStatement = connection.prepareStatement(nameMethod);
 //      preparedStatement.setString(1, whereName);
 //      preparedStatement.executeUpdate();
 //      return preparedStatement;
 //  }
     public static ResultSet performStatement(String nameMethod)throws SQLException, ClassNotFoundException{
        connectionToDataBase(getProperties());
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(nameMethod);
        return resultSet;
     }
}
