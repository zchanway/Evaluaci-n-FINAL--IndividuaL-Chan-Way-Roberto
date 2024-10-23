package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service.impl;

import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.convert.LibroConvert;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.exception.NotFoundException;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Autor;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Categoria;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Libro;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.repository.AutorRepository;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.repository.CategoriaRepository;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.repository.LibroRepository;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.service.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.libreriachanway.ws.objects.*;

@RequiredArgsConstructor
@Service
public class LibroService implements ILibroService {
    private final LibroConvert libroConvert;
    private final LibroRepository libroRepository;
    private final CategoriaRepository categoriaRepository;
    private final AutorRepository autorRepository;

    @Override
    public GetLibrosResponse obtenerTodosLosLibros() {
        GetLibrosResponse getLibrosResponse = new GetLibrosResponse();
        getLibrosResponse.getLibros().addAll(
                libroConvert.convertToListLibroWs(libroRepository.findAll())
        );
        return getLibrosResponse;
    }

    @Override
    public GetLibroResponse obtenerLibroXId(Long id) {
        GetLibroResponse getLibroResponse = new GetLibroResponse();
        Libro libro = libroRepository.findById(id).orElse(null);
        if(libro == null){
            throw  new NotFoundException("El Porducto con el id" + id + " no existe");
        }
        getLibroResponse.setLibro(libroConvert.convertToLibroWs(libro));
        return getLibroResponse;
    }

    @Override
    public GetLibroResponse guardarLibro(PostLibroRequest request) {

        if (request.getLibro() == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }

        Librows librows = request.getLibro();


        Categoria categoria = categoriaRepository.findById(librows.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));

        Autor autor = autorRepository.findById(librows.getAutorId())
                .orElseThrow(() -> new NotFoundException("Autor no encontrado"));


        Libro nuevoLibro = libroConvert.convertToLibro(librows, autor, categoria);


        Libro libroGuardado = libroRepository.save(nuevoLibro);


        GetLibroResponse response = new GetLibroResponse();
        response.setLibro(libroConvert.convertToLibroWs(libroGuardado));

        return response;
    }



    @Override
    public GetLibroResponse editarLibro(PutLibroRequest request) {

        if (request.getLibro() == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }

        Librows librows = request.getLibro();


        Libro libroExistente = libroRepository.findById(librows.getId())
                .orElseThrow(() -> new NotFoundException("Libro no encontrado"));


        Categoria categoria = categoriaRepository.findById(librows.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));

        Autor autor = autorRepository.findById(librows.getAutorId())
                .orElseThrow(() -> new NotFoundException("Autor no encontrado"));


        libroExistente.setTitulo(librows.getTitulo());
        libroExistente.setPrecio(librows.getPrecio());
        libroExistente.setAutor(autor);
        libroExistente.setCategoria(categoria);

        Libro libroActualizado = libroRepository.save(libroExistente);

        GetLibroResponse response = new GetLibroResponse();
        response.setLibro(libroConvert.convertToLibroWs(libroActualizado));

        return response;
    }

}
