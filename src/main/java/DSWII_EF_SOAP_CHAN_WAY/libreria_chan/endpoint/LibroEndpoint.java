package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.endpoint;

import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.com.libreriachanway.ws.objects.*;

@Endpoint
public class LibroEndpoint {
    private static final String NAMESPACE_URI = "http://www.libreriaChanWay.com.pe/ws/objects";

    @Autowired
    private ILibroService libroService;

    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "getLibrosRequest")
    @ResponsePayload
    public GetLibrosResponse getLibros(@RequestPayload GetLibrosRequest request){
        return libroService.obtenerTodosLosLibros();
    }

    @PayloadRoot(namespace = NAMESPACE_URI , localPart ="getLibroRequest" )
    @ResponsePayload
    public GetLibroResponse getLibroPorId(@RequestPayload GetLibroRequest request){
        return  libroService.obtenerLibroXId(request.getId());
    }
    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "postLibroRequest")
    @ResponsePayload
    public GetLibroResponse saveLibro(@RequestPayload PostLibroRequest request){
        return libroService.guardarLibro(request);
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putLibroRequest")
    @ResponsePayload
    public GetLibroResponse actualizarLibro(@RequestPayload PutLibroRequest request){
        return libroService.editarLibro(request);
    }

}
