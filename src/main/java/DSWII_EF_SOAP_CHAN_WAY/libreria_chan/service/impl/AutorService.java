package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service.impl;

import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.exception.NotFoundException;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Autor;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.repository.AutorRepository;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service.IAutorService;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.convert.AutorConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.libreriachanway.ws.objects.*;

@Service
@RequiredArgsConstructor
public class AutorService implements IAutorService {

    private final AutorRepository autorRepository;
    private final AutorConvert autorConvert;

    @Override
    public GetAutoresResponse obtenerTodosLosAutores() {
        GetAutoresResponse getAutoresResponse = new GetAutoresResponse();
        getAutoresResponse.getAutores().addAll(
                autorConvert.convertToListAutorWs(autorRepository.findAll())
        );
        return getAutoresResponse;
    }

    @Override
    public GetAutorResponse obtenerAutorPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Autor no encontrado"));

        GetAutorResponse response = new GetAutorResponse();
        response.setAutor(autorConvert.convertToAutorWs(autor));
        return response;
    }

    @Override
    public GetAutorResponse guardarAutor(PostAutorRequest request) {
        if (request.getAutor() == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo");
        }

        Autorws autorWs = request.getAutor();
        Autor nuevoAutor = autorConvert.convertToAutor(autorWs);
        Autor autorGuardado = autorRepository.save(nuevoAutor);

        GetAutorResponse response = new GetAutorResponse();
        response.setAutor(autorConvert.convertToAutorWs(autorGuardado));
        return response;
    }

    @Override
    public GetAutorResponse editarAutor(PutAutorRequest request) {
        if (request.getAutor() == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo");
        }

        Autorws autorWs = request.getAutor();
        Autor autorExistente = autorRepository.findById(autorWs.getId())
                .orElseThrow(() -> new NotFoundException("Autor no encontrado"));

        autorExistente.setNombre(autorWs.getNombre());
        autorExistente.setBiografia(autorWs.getBiografia());

        Autor autorActualizado = autorRepository.save(autorExistente);

        GetAutorResponse response = new GetAutorResponse();
        response.setAutor(autorConvert.convertToAutorWs(autorActualizado));
        return response;
    }
}
