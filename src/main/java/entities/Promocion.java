package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = "articulos")
@Builder
@Entity
@Table(name = "Promocion")
public class Promocion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String denominacion;

    @Column
    private LocalDate fechaDesde;

    @Column
    private LocalDate fechaHasta;

    @Column
    private LocalTime horaDesde;

    @Column
    private LocalTime horaHasta;

    @Column
    private String descripcionDescuento;

    @Column
    private Double precioPromocional;

    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Imagen> promoImagen = new HashSet<>();

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "promociones_articulo",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    private Set<Articulo> articulos = new HashSet<>();
}
