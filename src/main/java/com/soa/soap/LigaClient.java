/**
 * 
 */
package com.soa.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soa.dto.MarcadoresLizbeth;
import com.soa.dto.MaximoGoleadorVelasco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase que genera el método de ejecución de un servicio web.
 */
public class LigaClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(LigaClient.class);

    public MaximoGoleadorVelasco execute() {

        MarcadoresLizbeth request = new MarcadoresLizbeth();
        request.setLiga(null);

        log.info("Executing WS");

        MaximoGoleadorVelasco response = (MaximoGoleadorVelasco) 
                getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/liga", request, 
                new SoapActionCallback("http://soa.com/MarcadoresLizbeth"));

        return response;
    }

}