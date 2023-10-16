package fr.insa.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "TestServices")
public class TestServices {
    @WebMethod(operationName = "wordLength_")
    public int wordLength_(@WebParam(name = "word_") String word_) {
        return word_.length();
    }
}
