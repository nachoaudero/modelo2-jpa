package org.example.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@Builder
@Entity

public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;


    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private UnidadMedida unidadMedida;


    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

}