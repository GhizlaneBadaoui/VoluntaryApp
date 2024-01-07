package fr.insa.ws;

import fr.insa.ws.database.JDBC;
import fr.insa.ws.model.Requester;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Requester> RequestersList;
    public static String host = "localhost";
    public static short port1 = 8089;
    public static short port2 = 8088;
    public static short port3 = 8087;

    public void demarrerServiceRequester() {
        String url = "http://"+host+":"+port1+"/";
        Endpoint.publish(url, new RequesterServices());
    }

    public void demarrerServiceMission() {
        String url = "http://"+host+":"+port2+"/";
        Endpoint.publish(url, new MissionServices());
    }

    public void demarrerServiceVolunteer() {
        String url = "http://"+host+":"+port3+"/";
        Endpoint.publish(url, new VolunteerServices());
    }

    public static void main(String[] args) throws MalformedURLException {
        JDBC.connectToDB("voluntaryapp");
        new Main().demarrerServiceRequester();
        RequestersList = new ArrayList<>();
        System.out.println("RequesterServices has been launched !");

//        new Main().demarrerServiceMission();
//        System.out.println("MissionServices has been launched !");
//
//        new Main().demarrerServiceVolunteer();
//        System.out.println("VolunteerServices has been launched !");
    }
}