package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private int cantidad;

    @Column(length = 500)
    private String descripcion;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
}
