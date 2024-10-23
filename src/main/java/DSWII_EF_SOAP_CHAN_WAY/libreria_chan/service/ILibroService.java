package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service;

import pe.com.libreriachanway.ws.objects.GetLibroResponse;
import pe.com.libreriachanway.ws.objects.GetLibrosResponse;
import pe.com.libreriachanway.ws.objects.PostLibroRequest;
import pe.com.libreriachanway.ws.objects.PutLibroRequest;

public interface ILibroService {
    GetLibrosResponse obtenerTodosLosLibros();
    GetLibroResponse  obtenerLibroXId(Long id);
    GetLibroResponse guardarLibro(PostLibroRequest request);
    GetLibroResponse  editarLibro(PutLibroRequest request);

}
