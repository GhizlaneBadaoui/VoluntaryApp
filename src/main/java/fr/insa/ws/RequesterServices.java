package fr.insa.ws;

import fr.insa.ws.model.Requester;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.sql.SQLException;

@WebService(serviceName = "RequesterServices")
public class RequesterServices {
    @WebMethod(operationName = "subscribe")
    public Requester subscribe(@WebParam(name = "name") String name, @WebParam(name = "mail") String mail, @WebParam(name = "phoneNumber") String phoneNumber, @WebParam(name = "address")String address)  {
        return new Requester(name,mail,phoneNumber,address);
    }

    @WebMethod(operationName = "unsubscribe")
    public void unsubscribe(@WebParam(name = "mail") String mail) {
        Requester.RemoveRequester(mail);
    }

    @WebMethod(operationName = "updateRequester")
    public void update(@WebParam(name = "mail") String mail, @WebParam(name = "name") String name) {
        Requester.updateRequester(mail, name);
    }

    @WebMethod(operationName = "getRequester")
    public String getRequester(@WebParam(name = "mail") String mail) {
        return Requester.getRequesterInfo(mail);
    }
}