package fr.insa.ws.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.insa.ws.database.JDBC.connection;

public class VolunteerTable {

    public static void addVolunteer(String name, String mail, String phone, String address) {
        String querySql = "insert into volunteers(name, mail, phonenumber, address) values ('"+name+"','"+mail+"','"+phone+"','"+address+"')";
        try {
            connection.createStatement().execute(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteVolunteer(String mail) {
        String querySql = "delete from volunteers where mail = '"+mail+"'";
        try {
            connection.createStatement().execute(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateVolunteer(String mail, String name) {
        String querySql = "update volunteers set name = '"+name+"'where mail = '"+mail+"'";
        try {
            connection.createStatement().execute(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getVolunteer(String mail) {
        String querySql = "select * from volunteers where mail = '"+mail+"'";
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(querySql);
            while (resultSet.next()){
                return "volunteerId : "+resultSet.getString("volunteerId")+" name : "+ resultSet.getString("name")+" mail : "+resultSet.getString("mail")+" phone : "+resultSet.getString("phonenumber")+" address : "+resultSet.getString("address");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}