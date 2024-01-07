package fr.insa.ws.database;

import java.sql.*;

public class JDBC {
    public static Connection connection;
    private static String DBServer = "jdbc:mysql://localhost:3306/";
    private static String user = "root";
    private static String password = "root";
    public static String connectToDB(String databaseName){
        try {
            connection = DriverManager.getConnection(DBServer+databaseName,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from requesters");
            while (resultSet.next()){
                System.out.println(resultSet.getString("requesterid")+" "+ resultSet.getString("name"));
            }
            System.out.println("The connection has been successfully set up");
        }
        catch (SQLException e){
            System.out.println("the connection has been failed");
        }
        return "";
    }
}