package fr.insa.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "TestWS")
public class TestWS {
    @WebMethod(operationName = "wordLength")
    public int wordLength(@WebParam(name = "word") String word) {
        return word.length();
    }
}
