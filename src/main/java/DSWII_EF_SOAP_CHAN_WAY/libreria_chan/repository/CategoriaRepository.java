package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.repository;

import DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
}
