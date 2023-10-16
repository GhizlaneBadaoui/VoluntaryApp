package fr.insa.ws.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.insa.ws.database.JDBC.connection;

public class VolunteerTable {

    public static void addVolunteer(String name, String mail, String phone, String address) throws SQLException {
        String querySql = "insert into volunteers(name, mail, phonenumber, address) values ('"+name+"','"+mail+"','"+phone+"','"+address+"')";
        connection.createStatement().execute(querySql);
    }

    public static void deleteVolunteer(String mail) throws SQLException {
        String querySql = "delete from volunteers where mail = '"+mail+"'";
        connection.createStatement().execute(querySql);
    }

    public static void updateVolunteer(String mail, String name) throws SQLException {
        String querySql = "update volunteers set name = '"+name+"'where mail = '"+mail+"'";
        connection.createStatement().execute(querySql);
    }

    public static String getVolunteer(String mail) throws SQLException {
        String querySql = "select * from volunteers where mail = '"+mail+"'";
        ResultSet resultSet = connection.createStatement().executeQuery(querySql);
        while (resultSet.next()){
            return "volunteerId : "+resultSet.getString("volunteerId")+" name : "+ resultSet.getString("name")+" mail : "+resultSet.getString("mail")+" phone : "+resultSet.getString("phonenumber")+" address : "+resultSet.getString("address");
        }
        return "";
    }
}