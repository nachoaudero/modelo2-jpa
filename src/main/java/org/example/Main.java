package org.example;

import org.example.entities.Articulo;
import org.example.entities.Imagen;
import org.example.entities.UnidadMedida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        }catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Error");
        }

        em.close();
        emf.close();
    }
}
