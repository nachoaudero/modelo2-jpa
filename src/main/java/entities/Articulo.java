package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "Articulo")
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String denominacion;

    @Column
    private Double precioVenta;

    @Column
    private Double precioCompra;

    @Column
    private Integer stockActual;

    @Column
    private Integer stockMaximo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_imagen")
    private Imagen imagen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_unidadmedida")
    private UnidadMedida unidadMedida;

}
