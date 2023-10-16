package fr.insa.ws;

import fr.insa.ws.model.Volunteer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
@WebService(serviceName = "VolunteerServices")
public class VolunteerServices {

    @WebMethod(operationName = "subscribe")
    public Volunteer subscribe(@WebParam(name = "name") String name, @WebParam(name = "mail") String mail, @WebParam(name = "phoneNumber") String phoneNumber, @WebParam(name = "address")String address) throws SQLException {
        Volunteer volunteer = new Volunteer(name,mail,phoneNumber,address);
        return volunteer;
    }

    @WebMethod(operationName = "unsubscribe")
    public void unsubscribe(@WebParam(name = "mail") String mail) throws SQLException {
        Volunteer.RemoveVolunteer(mail);
    }

    @WebMethod(operationName = "updateVolunteer")
    public void update(@WebParam(name = "mail") String mail, @WebParam(name = "name") String name) throws SQLException {
        Volunteer.updateVolunteer(mail, name);
    }

    @WebMethod
    public String getVolunteer(@WebParam(name = "mail")String mail) throws SQLException {
        return Volunteer.getVolunteerInfo(mail);
    }
}