package fr.insa.ws.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.insa.ws.database.JDBC.connection;

public class RequesterTable {

    public static void addRequester(String name, String mail, String phone, String address) {
        String querySql = "insert into requesters(name, mail, phonenumber, address) values ('"+name+"','"+mail+"','"+phone+"','"+address+"')";
        try {
            connection.createStatement().execute(querySql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteRequester(String mail) {
        String querySql = "delete from requesters where mail = '"+mail+"'";
        try {
            connection.createStatement().execute(querySql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateRequester(String mail, String name){
        String querySql = "update requesters set name = '"+name+"'where mail = '"+mail+"'";
        try {
            connection.createStatement().execute(querySql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static String getRequester(String mail) {
        String querySql = "select * from requesters where mail = '"+mail+"'";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(querySql);
            while (resultSet.next()){
                return "RequesterId : "+resultSet.getString("requesterid")+" name : "+ resultSet.getString("name")+" mail : "+resultSet.getString("mail")+" phone : "+resultSet.getString("phonenumber")+" address : "+resultSet.getString("address");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "";
    }
}