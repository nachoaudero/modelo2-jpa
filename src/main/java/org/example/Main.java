package org.example;

import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example_unit");
        EntityManager em = emf.createEntityManager();

        try {
            // Definiendo Porciones
            UnidadMedida porcionesOcho = UnidadMedida.builder().denominacion("8 porciones").build();
            UnidadMedida porcionesCuatro = UnidadMedida.builder().denominacion("4 porciones").build();
            UnidadMedida porcionLitro = UnidadMedida.builder().denominacion("1 Litro").build();

            // Imagenes Productos y Promos
            Imagen imagen1 = Imagen.builder().denominacion("Pizza grande Hawaiana").build();
            Imagen imagen2 = Imagen.builder().denominacion("Pizza grande Napolitana").build();
            Imagen imagen3 = Imagen.builder().denominacion("Pizza grande Muzza").build();
            Imagen imagen4 = Imagen.builder().denominacion("Pizza chica Hawaiana").build();
            Imagen imagen5 = Imagen.builder().denominacion("Pizza chica Napolitana").build();
            Imagen imagen6 = Imagen.builder().denominacion("Pizza chica Napo").build();
            Imagen imagen7 = Imagen.builder().denominacion("Cerveza Andes").build();
            Imagen imagen8 = Imagen.builder().denominacion("Cerveza Quilmes").build();
            Imagen imahappy1 = Imagen.builder().denominacion("Promo Happy Hour!").build();
            Imagen imahappy2 = Imagen.builder().denominacion("Promo Happy Hour!").build();
            Imagen verano1 = Imagen.builder().denominacion("Promo Verano!").build();
            Imagen verano2 = Imagen.builder().denominacion("Promo Verano!").build();
            Imagen invierno1 = Imagen.builder().denominacion("Promo Invierno!").build();
            Imagen invierno2 = Imagen.builder().denominacion("Promo Invierno!").build();

            // Creando Productos
            Articulo pizzaGrande1 = Articulo.builder()
                    .denominacion("Pizza Grande Hawaiana")
                    .precioVenta(5000D)
                    .precioCompra(3000D)
                    .stockActual(80)
                    .stockMaximo(100)
                    .imagen(imagen1)
                    .unidadMedida(porcionesOcho)
                    .build();

            Articulo pizzaChica1 = Articulo.builder()
                    .denominacion("Pizza Chica Hawaiana")
                    .precioVenta(4000D)
                    .precioCompra(2000D)
                    .stockActual(100)
                    .stockMaximo(150)
                    .imagen(imagen4)
                    .unidadMedida(porcionesCuatro)
                    .build();

            Articulo pizzaGrande2 = Articulo.builder()
                    .denominacion("Pizza Grande Napolitana")
                    .precioVenta(4500D)
                    .precioCompra(3100D)
                    .stockActual(75)
                    .stockMaximo(110)
                    .imagen(imagen2)
                    .unidadMedida(porcionesOcho)
                    .build();

            Articulo pizzaChica2 = Articulo.builder()
                    .denominacion("Pizza Chica Napolitana")
                    .precioVenta(3500D)
                    .precioCompra(1500D)
                    .stockActual(120)
                    .stockMaximo(175)
                    .imagen(imagen5)
                    .unidadMedida(porcionesCuatro)
                    .build();

            Articulo pizzaGrande3 = Articulo.builder()
                    .denominacion("Pizza Grande Muzza")
                    .precioVenta(4700D)
                    .precioCompra(3200D)
                    .stockActual(90)
                    .stockMaximo(130)
                    .imagen(imagen3)
                    .unidadMedida(porcionesOcho)
                    .build();

            Articulo pizzaChica3 = Articulo.builder()
                    .denominacion("Pizza Chica Muzza")
                    .precioVenta(3800D)
                    .precioCompra(2000D)
                    .stockActual(60)
                    .stockMaximo(150)
                    .imagen(imagen6)
                    .unidadMedida(porcionesCuatro)
                    .build();

            Articulo cerveza1 = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(2000D)
                    .precioCompra(1000D)
                    .stockActual(175)
                    .stockMaximo(200)
                    .imagen(imagen7)
                    .unidadMedida(porcionLitro)
                    .build();
            Articulo cerveza2 = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(1800D)
                    .precioCompra(900D)
                    .stockActual(151)
                    .stockMaximo(200)
                    .imagen(imagen8)
                    .unidadMedida(porcionLitro)
                    .build();

            // CREACION DE PROMOS
            Promocion promocion1 = Promocion.builder()
                    .denominacion("Promocion Happy Hour Septiembre")
                    .fechaDesde(LocalDate.of(2024, 9, 1))
                    .fechaHasta(LocalDate.of(2024, 9,30))
                    .horaDesde(LocalTime.of(16,30))
                    .horaHasta(LocalTime.of(20, 30))
                    .descripcionDescuento("Promocion Septiembre Happy Hour 15%off llevando 1 Pizza Grande Hawaiana, 1 Pizza Grande Mizza y 1 Cerveza QUilmes")
                    .tipoPromocion(TipoPromocion.happyHour)
                    .build();

            promocion1.getPromoImagen().add(imahappy1);
            promocion1.getPromoImagen().add(imahappy2);
            promocion1.getArticulos().add(pizzaGrande1);
            promocion1.getArticulos().add(pizzaGrande3);
            promocion1.getArticulos().add(cerveza2);

            Double precioProm1 = 0D;
            for (Articulo articulo: promocion1.getArticulos()) {
                precioProm1 += articulo.getPrecioVenta();
            }
            promocion1.setPrecioPromocional(precioProm1*0.85);

            Promocion promocion2 = Promocion.builder()
                    .denominacion("Promocion Verano")
                    .fechaDesde(LocalDate.of(2024, 12,21))
                    .fechaHasta(LocalDate.of(2025, 3, 21))
                    .horaDesde(LocalTime.of(0,0))
                    .horaHasta(LocalTime.of(23,59))
                    .descripcionDescuento("Promocion Verano 20% off llevando 1 Pizza Chica Hawaiana, 1 Pizza Grande Napolitana, 1 Cerveza Quilmes y 1 Cerveza Andes")
                    .tipoPromocion(TipoPromocion.Verano)
                    .build();

            promocion2.getPromoImagen().add(verano1);
            promocion2.getPromoImagen().add(verano2);
            promocion2.getArticulos().add(pizzaChica1);
            promocion2.getArticulos().add(pizzaGrande2);
            promocion2.getArticulos().add(cerveza1);
            promocion2.getArticulos().add(cerveza2);

            precioProm1 = 0D;
            for (Articulo articulo: promocion2.getArticulos()) {
                precioProm1 += articulo.getPrecioVenta();
            }
            promocion2.setPrecioPromocional(precioProm1*0.8);

            Promocion promocion3 = Promocion.builder()
                    .denominacion("Promocion Incierno")
                    .fechaDesde(LocalDate.of(2025, 6, 21))
                    .fechaHasta(LocalDate.of(2025, 9, 21))
                    .horaDesde(LocalTime.of(0,0))
                    .horaHasta(LocalTime.of(0,0))
                    .descripcionDescuento("Promocion Invierno 30% off llevando 1 Pizza Grande Hawaiana, 1 Pizza Chica Muzza y 1 Cerveza Quilmes")
                    .tipoPromocion(TipoPromocion.Invierno)
                    .build();

            promocion3.getPromoImagen().add(invierno1);
            promocion3.getPromoImagen().add(invierno2);
            promocion3.getArticulos().add(pizzaGrande1);
            promocion3.getArticulos().add(pizzaChica3);
            promocion3.getArticulos().add(cerveza2);

            precioProm1 = 0D;
            for (Articulo articulo: promocion3.getArticulos()) {
                precioProm1 += articulo.getPrecioVenta();
            }
            promocion3.setPrecioPromocional(precioProm1*0.7);

            //PERSISTENCIAS

            em.getTransaction().begin();
            em.persist(imagen1);
            em.persist(imagen2);
            em.persist(imagen3);
            em.persist(imagen4);
            em.persist(imagen5);
            em.persist(imagen6);
            em.persist(imagen7);
            em.persist(imagen8);
            em.persist(imahappy1);
            em.persist(imahappy2);
            em.persist(verano1);
            em.persist(verano2);
            em.persist(invierno1);
            em.persist(invierno2);

            em.persist(porcionesOcho);
            em.persist(porcionesCuatro);
            em.persist(porcionLitro);

            em.persist(pizzaGrande1);
            em.persist(pizzaGrande2);
            em.persist(pizzaGrande3);
            em.persist(pizzaChica1);
            em.persist(pizzaChica2);
            em.persist(pizzaChica3);
            em.persist(cerveza1);
            em.persist(cerveza2);

            em.persist(promocion1);
            em.persist(promocion2);
            em.persist(promocion3);

            em.getTransaction().commit();

            System.out.println("Todo Cargado con Exito");

        }catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Error");
        }

        em.close();
        emf.close();
    }
}
