package fr.insa.ws;

import fr.insa.ws.model.Mission;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;

@WebService(serviceName = "MissionServices")
public class MissionServices {

    @WebMethod(operationName = "addMission")
    public Mission addMission(@WebParam(name = "submitterMail")String submitterMail, @WebParam(name = "description") String description, @WebParam(name = "state")Mission.State state, @WebParam(name = "submitter")Mission.Submitter submitter) throws SQLException {
        Mission mission = new Mission(submitterMail, description, state, submitter);
        return mission;
    }
}