package org.example;

import org.example.entities.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try {
            // UNIDADES DE MEDIDA
            UnidadMedida ochoPorciones = UnidadMedida.builder().denominacion("8 porciones").build();
            UnidadMedida cuatroPorciones = UnidadMedida.builder().denominacion("4 porciones").build();
            UnidadMedida unLitro = UnidadMedida.builder().denominacion("1 litro").build();

            // IMAGENES
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

            // PIZZA GRANDE HAWAIANA
            Articulo pizzaHawaianaGrande = Articulo.builder()
                    .denominacion("Pizza grande Hawaiana.")
                    .precioVenta(10500D)
                    .precioCompra(8900D)
                    .stockActual(80)
                    .stockMaximo(100)
                    .unidadMedida(ochoPorciones)
                    .imagen(imagen1)
                    .build();
            // PIZZA CHICA HAWAIANA
            Articulo pizzaHawaianaChica = Articulo.builder()
                    .denominacion("Pizza chica Hawaiana.")
                    .precioVenta(8500D)
                    .precioCompra(6950D)
                    .stockActual(70)
                    .stockMaximo(120)
                    .unidadMedida(cuatroPorciones)
                    .imagen(imagen4)
                    .build();
            // PIZZA GRANDE NAPOLITANA
            Articulo pizzaNapolitanaGrande = Articulo.builder()
                    .denominacion("Pizza grande Napolitana")
                    .precioVenta(10000D)
                    .precioCompra(8500D)
                    .stockActual(50)
                    .stockMaximo(90)
                    .unidadMedida(ochoPorciones)
                    .imagen(imagen2)
                    .build();
            // PIZZA CHICA NAPOLITANA
            Articulo pizzaNapolitanaChica = Articulo.builder()
                    .denominacion("Pizza chica Napolitana")
                    .precioVenta(9000D)
                    .precioCompra(7900D)
                    .stockActual(60)
                    .stockMaximo(100)
                    .unidadMedida(cuatroPorciones)
                    .imagen(imagen5)
                    .build();
            // PIZZA GRANDE MUZZA
            Articulo pizzaMuzzaGrande = Articulo.builder()
                    .denominacion("Pizza grande Muzza")
                    .precioVenta(7500D)
                    .precioCompra(5000D)
                    .stockActual(90)
                    .stockMaximo(150)
                    .unidadMedida(ochoPorciones)
                    .imagen(imagen3)
                    .build();
            // PIZZA CHICA MUZZA
            Articulo pizzaMuzzaChica = Articulo.builder()
                    .denominacion("Pizza chica Muzza")
                    .precioVenta(6000D)
                    .precioCompra(3500D)
                    .stockActual(120)
                    .stockMaximo(200)
                    .unidadMedida(cuatroPorciones)
                    .imagen(imagen6)
                    .build();
            // CERVEZA ANDES
            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(2000D)
                    .precioCompra(1500D)
                    .stockActual(40)
                    .stockMaximo(60)
                    .unidadMedida(unLitro)
                    .imagen(imagen7)
                    .build();
            // CERVEZA QUILMES
            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(2000D)
                    .precioCompra(1500D)
                    .stockActual(30)
                    .stockMaximo(60)
                    .unidadMedida(unLitro)
                    .imagen(imagen8)
                    .build();

            // PROMO HAPPY HOUR
            Promocion promoHappyHour = Promocion.builder()
                    .denominacion("Promocion Happy Hour Mes de la primavera!")
                    .fechaDesde(LocalDate.of(2024, 9,1))
                    .fechaHasta(LocalDate.of(2024, 9, 30))
                    .horaDesde(LocalTime.of(15, 0))
                    .horaHasta(LocalTime.of(23,55))
                    .descripcionDescuento("Promocion por el mes de la primavera, 20% de descuento pidiendo 1 pizza grande Hawaiana + 1 pizza grande Muzza + 1 cerveza Quilmes.")
                    .tipoPromocion(TipoPromocion.happyHour)
                    .build();
            promoHappyHour.getPromoImagen().add(imahappy1);
            promoHappyHour.getPromoImagen().add(imahappy2);
            promoHappyHour.getArticulos().add(pizzaHawaianaGrande);
            promoHappyHour.getArticulos().add(pizzaMuzzaGrande);
            promoHappyHour.getArticulos().add(cervezaQuilmes);

            Double precioPromoHappy = 0D;
            for (Articulo art : promoHappyHour.getArticulos()){
                precioPromoHappy += art.getPrecioVenta();
            }
            promoHappyHour.setPrecioPromocional(precioPromoHappy * 0.80);

            // PROMO VERANO
            Promocion promoVerano = Promocion.builder()
                    .denominacion("Promocion Verano Feliz!")
                    .fechaDesde(LocalDate.of(2024, 12,1))
                    .fechaHasta(LocalDate.of(2025, 2, 28))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(23,55))
                    .descripcionDescuento("Promocion por el mes VERANO, 25% de descuento pidiendo 1 pizza chica Hawaiana + 1 pizza grande Napolitana + 1 cerveza Andes.")
                    .tipoPromocion(TipoPromocion.Verano)
                    .build();
            promoVerano.getPromoImagen().add(verano1);
            promoVerano.getPromoImagen().add(verano2);
            promoVerano.getArticulos().add(pizzaHawaianaChica);
            promoVerano.getArticulos().add(pizzaNapolitanaGrande);
            promoVerano.getArticulos().add(cervezaAndes);
            promoVerano.getArticulos().add(cervezaQuilmes);

            Double precioPromoVerano = 0D;
            for (Articulo art : promoVerano.getArticulos()){
                precioPromoVerano += art.getPrecioVenta();
            }
            promoVerano.setPrecioPromocional(precioPromoVerano * 0.75);

            // PROMO INVIERNO
            Promocion promoInvierno = Promocion.builder()
                    .denominacion("Promocion Invierno Feliz!")
                    .fechaDesde(LocalDate.of(2025, 5,1))
                    .fechaHasta(LocalDate.of(2025, 7, 31))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(23,55))
                    .descripcionDescuento("Promocion por el mes INVIERNO, 15% de descuento pidiendo 1 pizza grande Hawaiana + 1 pizza chica Muzza + 1 cerveza Quilmes.")
                    .tipoPromocion(TipoPromocion.Invierno)
                    .build();
            promoInvierno.getPromoImagen().add(invierno1);
            promoInvierno.getPromoImagen().add(invierno2);
            promoInvierno.getArticulos().add(pizzaHawaianaGrande);
            promoInvierno.getArticulos().add(pizzaMuzzaChica);
            promoInvierno.getArticulos().add(cervezaQuilmes);

            Double precioInvierno = 0D;
            for (Articulo art : promoInvierno.getArticulos()){
                precioInvierno += art.getPrecioVenta();
            }
            promoInvierno.setPrecioPromocional(precioInvierno * 0.85);

            // PERSISTIR LOS ARTICULOS Y LAS PROMOCIONES
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

            em.persist(ochoPorciones);
            em.persist(cuatroPorciones);
            em.persist(unLitro);

            em.persist(pizzaHawaianaGrande);
            em.persist(pizzaHawaianaChica);
            em.persist(pizzaNapolitanaGrande);
            em.persist(pizzaNapolitanaChica);
            em.persist(pizzaMuzzaGrande);
            em.persist(pizzaMuzzaChica);
            em.persist(cervezaAndes);
            em.persist(cervezaQuilmes);

            em.persist(promoHappyHour);
            em.persist(promoVerano);
            em.persist(promoInvierno);

            em.getTransaction().commit();

            System.out.println("TODOS LOS ARTICULOS Y PROMOCIONES HAN SIDO CARGADOS CON EXITO!!!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Ocurrio un error.");
        }

        em.close();
        emf.close();
    }
}
