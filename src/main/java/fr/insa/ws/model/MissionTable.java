package fr.insa.ws.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.insa.ws.database.JDBC.connection;

public class MissionTable {

    public static void addMission(String submitterMail, String description, Mission.State state, Mission.Submitter submitter) {
        String sub = (submitter == Mission.Submitter.volunteer) ? "volunteerMail" : "requesterMail";
        String querySql = "insert into Mission("+sub+", description, state, submitter) values ('"+submitterMail+"','"+description+"','"+state+"','"+submitter+"')";
        try {
            connection.createStatement().execute(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMission(int id) {
        String querySql = "delete from Mission where mail = '"+id+"'";
        try {
            connection.createStatement().execute(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkSubmitter(String mail, Mission.Submitter submitterType ) {
        if (submitterType == Mission.Submitter.volunteer){
            if(VolunteerTable.getVolunteer(mail).equals(""))
                return false;
            else
                return true;
        }
        else{
            if(RequesterTable.getRequester(mail).equals(""))
                return false;
            else
                return true;
        }
    }

    public static void updateState(int id, Mission.State state) {
        String querySql = "update volunteers set state = '"+state+"'where mail = '"+id+"'";
        try {
            connection.createStatement().execute(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getMission(int id) {
        String querySql = "select * from Mission where missionId = '"+id+"'";
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(querySql);
            while (resultSet.next()){
                return "MissionId : "+resultSet.getString("missionId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}