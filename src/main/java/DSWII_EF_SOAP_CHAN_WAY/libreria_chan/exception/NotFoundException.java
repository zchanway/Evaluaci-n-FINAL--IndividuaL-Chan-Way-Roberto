package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.exception;


import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{http://www.libreriaChanWay.com.pe/ws}001")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}