package fr.insa.ws.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import static fr.insa.ws.database.JDBC.connection;

public class MissionTable {



    public static void addMission(String submitterMail, String description, Mission.State state, Mission.Submitter submitter) throws SQLException {
        String sub = (submitter == Mission.Submitter.volunteer) ? "volunteerMail" : "requesterMail";
        String querySql = "insert into Mission("+sub+", description, state, submitter) values ('"+submitterMail+"','"+description+"','"+state+"','"+submitter+"')";
        connection.createStatement().execute(querySql);
    }

    public static void deleteMission(int id) throws SQLException {
        String querySql = "delete from Mission where mail = '"+id+"'";
        connection.createStatement().execute(querySql);
    }

    public static boolean checkSubmitter(String mail, Mission.Submitter submitterType ) throws SQLException {
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

    public static void updateState(int id, Mission.State state) throws SQLException {
        String querySql = "update volunteers set state = '"+state+"'where mail = '"+id+"'";
        connection.createStatement().execute(querySql);
    }

    public static String getMission(int id) throws SQLException {
        String querySql = "select * from Mission where missionId = '"+id+"'";
        ResultSet resultSet = connection.createStatement().executeQuery(querySql);
        while (resultSet.next()){
            return "MissionId : "+resultSet.getString("missionId");
        }
        return "";
    }
}