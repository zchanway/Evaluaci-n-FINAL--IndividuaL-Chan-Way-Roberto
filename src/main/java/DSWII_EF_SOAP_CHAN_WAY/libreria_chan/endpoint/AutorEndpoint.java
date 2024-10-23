package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service.IAutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.com.libreriachanway.ws.objects.GetAutorRequest;
import pe.com.libreriachanway.ws.objects.GetAutorResponse;
import pe.com.libreriachanway.ws.objects.GetAutoresResponse;
import pe.com.libreriachanway.ws.objects.PostAutorRequest;
import pe.com.libreriachanway.ws.objects.PutAutorRequest;
import pe.com.libreriachanway.ws.objects.PostAutorResponse;
import pe.com.libreriachanway.ws.objects.PutAutorResponse;

@Endpoint
@RequiredArgsConstructor
public class AutorEndpoint {

    private static final String NAMESPACE_URI = "http://libreriachanway.pe.com/ws/objects";

    private final IAutorService autorService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAutoresRequest")
    @ResponsePayload
    public GetAutoresResponse obtenerTodosLosAutores() {
        return autorService.obtenerTodosLosAutores();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAutorRequest")
    @ResponsePayload
    public GetAutorResponse obtenerAutorPorId(@RequestPayload GetAutorRequest request) {
        return autorService.obtenerAutorPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postAutorRequest")
    @ResponsePayload
    public PostAutorResponse guardarAutor(@RequestPayload PostAutorRequest request) {
        GetAutorResponse response = autorService.guardarAutor(request);
        PostAutorResponse postResponse = new PostAutorResponse();
        postResponse.setAutor(response.getAutor());
        return postResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putAutorRequest")
    @ResponsePayload
    public PutAutorResponse editarAutor(@RequestPayload PutAutorRequest request) {
        GetAutorResponse response = autorService.editarAutor(request);
        PutAutorResponse putResponse = new PutAutorResponse();
        putResponse.setAutor(response.getAutor());
        return putResponse;
    }
}