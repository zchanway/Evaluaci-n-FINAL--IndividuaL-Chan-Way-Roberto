package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service;

import pe.com.libreriachanway.ws.objects.GetAutorResponse;
import pe.com.libreriachanway.ws.objects.GetAutoresResponse;
import pe.com.libreriachanway.ws.objects.PostAutorRequest;
import pe.com.libreriachanway.ws.objects.PutAutorRequest;

public interface IAutorService {
    GetAutoresResponse obtenerTodosLosAutores();

    GetAutorResponse obtenerAutorPorId(Long id);

    GetAutorResponse guardarAutor(PostAutorRequest request);

    GetAutorResponse editarAutor(PutAutorRequest request);
}
