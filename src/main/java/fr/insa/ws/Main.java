package fr.insa.ws;

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
    public static short port4 = 8086;

    public void demarrerServiceRequester() {
        String url = "http://"+host+":"+port1+"/";
        Endpoint.publish(url, new RequesterServices());
    }

    public void demarrerServiceMission() {
        String url = "http://"+host+":"+port2+"/";
        Endpoint.publish(url, new MissionServices());
    }

    public void demarrerServiceTest() {
        String url = "http://"+host+":"+port3+"/";
        Endpoint.publish(url, new TestWS());
    }

    public void demarrerServiceTest2() {
        String url = "http://"+host+":"+port4+"/";
        Endpoint.publish(url, new TestServices());
    }
    public static void main(String[] args) throws MalformedURLException {

        new Main().demarrerServiceRequester();
        RequestersList = new ArrayList<>();
        System.out.println("Service RequesterServices has been launched !");

        new Main().demarrerServiceTest();
        System.out.println("Service TestWS has been launched !");

        new Main().demarrerServiceTest2();
        System.out.println("Service TestServices has been launched !");
    }
}