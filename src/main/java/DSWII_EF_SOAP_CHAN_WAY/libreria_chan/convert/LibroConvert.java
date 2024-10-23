package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.convert;

import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Autor;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Categoria;
import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Libro;
import org.springframework.stereotype.Component;
import pe.com.libreriachanway.ws.objects.Librows;
import java.util.ArrayList;
import java.util.List;

@Component
public class LibroConvert {


    public Libro convertToLibro(Librows libroWs, Autor autor, Categoria categoria) {
        Libro libro = new Libro();
        libro.setId(libroWs.getId());
        libro.setTitulo(libroWs.getTitulo());
        libro.setPrecio(libroWs.getPrecio());

        libro.setAutor(autor);
        libro.setCategoria(categoria);
        return libro;
    }


    public Librows convertToLibroWs(Libro libro) {
        Librows libroWs = new Librows();
        libroWs.setId(libro.getId());
        libroWs.setTitulo(libro.getTitulo());
        libroWs.setAutorId(libro.getAutor().getId());
        libroWs.setCategoriaId(libro.getCategoria().getId());
        libroWs.setPrecio(libro.getPrecio());

        return libroWs;
    }

    public List<Libro> convertToListLibro(List<Librows> libroWsList, List<Autor> autores, List<Categoria> categorias) {
        List<Libro> libroList = new ArrayList<>();
        for (Librows libroWs : libroWsList) {
            Autor autor = autores.stream()
                    .filter(a -> a.getId() == libroWs.getAutorId())
                    .findFirst()
                    .orElse(null);

            Categoria categoria = categorias.stream()
                    .filter(c -> c.getId() == libroWs.getCategoriaId())
                    .findFirst()
                    .orElse(null);

            libroList.add(convertToLibro(libroWs, autor, categoria));
        }
        return libroList;
    }


    public List<Librows> convertToListLibroWs(List<Libro> libroList) {
        List<Librows> libroWsList = new ArrayList<>();
        for (Libro libro : libroList) {
            libroWsList.add(convertToLibroWs(libro));
        }
        return libroWsList;
    }
}
