package fr.insa.ws.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.insa.ws.database.JDBC.connection;

public class RequesterTable {

    public static void addRequester(String name, String mail, String phone, String address) throws SQLException {
        String querySql = "insert into requesters(name, mail, phonenumber, address) values ('"+name+"','"+mail+"','"+phone+"','"+address+"')";
        connection.createStatement().execute(querySql);
    }

    public static void deleteRequester(String mail) throws SQLException {
        String querySql = "delete from requesters where mail = '"+mail+"'";
        connection.createStatement().execute(querySql);
    }

    public static void updateRequester(String mail, String name) throws SQLException {
        String querySql = "update requesters set name = '"+name+"'where mail = '"+mail+"'";
        connection.createStatement().execute(querySql);
    }

    public static String getRequester(String mail) throws SQLException {
        String querySql = "select * from requesters where mail = '"+mail+"'";
        ResultSet resultSet = connection.createStatement().executeQuery(querySql);
        while (resultSet.next()){
            return "RequesterId : "+resultSet.getString("requesterid")+" name : "+ resultSet.getString("name")+" mail : "+resultSet.getString("mail")+" phone : "+resultSet.getString("phonenumber")+" address : "+resultSet.getString("address");
        }
        return "";
    }
}