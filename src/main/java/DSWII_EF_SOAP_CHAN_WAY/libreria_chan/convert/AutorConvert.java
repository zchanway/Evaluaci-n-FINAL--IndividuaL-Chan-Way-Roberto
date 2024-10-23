package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.convert;

import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Autor;
import org.springframework.stereotype.Component;
import pe.com.libreriachanway.ws.objects.Autorws;

import java.util.ArrayList;
import java.util.List;
@Component
public class AutorConvert {

    public Autor convertToAutor(Autorws autorWs) {
        Autor autor = new Autor();
        autor.setId(autorWs.getId());
        autor.setNombre(autorWs.getNombre());
       autor.setBiografia(autorWs.getBiografia());
        return autor;
    }

    public Autorws convertToAutorWs(Autor autor) {
        Autorws autorWs = new Autorws();
        autorWs.setId(autor.getId());
        autorWs.setNombre(autor.getNombre());
        autorWs.setBiografia(autor.getBiografia());
        return autorWs;
    }

    public List<Autor> convertToListAutor(List<Autorws> autorWsList) {
        List<Autor> autorList = new ArrayList<>();
        for (Autorws autorWs : autorWsList) {
            autorList.add(convertToAutor(autorWs));
        }
        return autorList;
    }

    public List<Autorws> convertToListAutorWs(List<Autor> autorList) {
        List<Autorws> autorWsList = new ArrayList<>();
        for (Autor autor : autorList) {
            autorWsList.add(convertToAutorWs(autor));
        }
        return autorWsList;
    }
}
