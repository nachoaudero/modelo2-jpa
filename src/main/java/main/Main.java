package main;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("basePrueba");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Conexión exitosa!!");

        try {
            entityManager.getTransaction().begin();

            UnidadMedida ochoPorc = UnidadMedida.builder()
                    .denominacion("8 porciones")
                    .build();
            UnidadMedida cuatroPorc = UnidadMedida.builder()
                    .denominacion("4 porciones")
                    .build();
            UnidadMedida unLitro = UnidadMedida.builder()
                    .denominacion("1 litro")
                    .build();

            Imagen imagen1 = Imagen.builder()
                    .denominacion("Pizza Grande Hawaiana")
                    .build();
            Imagen imagen2 = Imagen.builder()
                    .denominacion("Pizza Grande Napolitana")
                    .build();
            Imagen imagen3 = Imagen.builder()
                    .denominacion("Pizza Grande Muzza")
                    .build();
            Imagen imagen4 = Imagen.builder()
                    .denominacion("Pizza Chica Hawaiana")
                    .build();
            Imagen imagen5 = Imagen.builder()
                    .denominacion("Pizza Chica Napolitana")
                    .build();
            Imagen imagen6 = Imagen.builder()
                    .denominacion("Pizza Chica Muzza")
                    .build();
            Imagen imagen7 = Imagen.builder()
                    .denominacion("Cerveza Andes")
                    .build();
            Imagen imagen8 = Imagen.builder()
                    .denominacion("Cerveza Quilmes")
                    .build();
            Imagen imaHappy1 = Imagen.builder()
                    .denominacion("Happy Hour")
                    .build();
            Imagen imaHappy2 = Imagen.builder()
                    .denominacion("Happy Hour")
                    .build();
            Imagen verano1 = Imagen.builder()
                    .denominacion("Promo Verano")
                    .build();
            Imagen verano2 = Imagen.builder()
                    .denominacion("Promo Verano")
                    .build();
            Imagen invierno1 = Imagen.builder()
                    .denominacion("Promo Invierno")
                    .build();
            Imagen invierno2 = Imagen.builder()
                    .denominacion("Promo Invierno")
                    .build();

            Articulo cerveza1 = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(5000D)
                    .precioCompra(3000D)
                    .stockActual(65)
                    .stockMaximo(150)
                    .imagen(imagen7)
                    .unidadMedida(unLitro)
                    .build();
            Articulo cerveza2 = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(6500D)
                    .precioCompra(4000D)
                    .stockActual(45)
                    .stockMaximo(150)
                    .imagen(imagen8)
                    .unidadMedida(unLitro)
                    .build();

            Articulo pizzaChica1 = Articulo.builder()
                    .denominacion("Pizza Chica Hawaiana")
                    .precioVenta(4500D)
                    .precioCompra(2750D)
                    .stockActual(20)
                    .stockMaximo(40)
                    .imagen(imagen4)
                    .unidadMedida(cuatroPorc)
                    .build();
            Articulo pizzaChica2 = Articulo.builder()
                    .denominacion("Pizza Chica Napolitana")
                    .precioVenta(4700D)
                    .precioCompra(2750D)
                    .stockActual(25)
                    .stockMaximo(35)
                    .imagen(imagen5)
                    .unidadMedida(cuatroPorc)
                    .build();
            Articulo pizzaChica3 = Articulo.builder()
                    .denominacion("Pizza Chica Muzza")
                    .precioVenta(3800D)
                    .precioCompra(2300D)
                    .stockActual(40)
                    .stockMaximo(75)
                    .imagen(imagen6)
                    .unidadMedida(cuatroPorc)
                    .build();
            Articulo pizzaGrande1 = Articulo.builder()
                    .denominacion("Pizza Grande Hawaiana")
                    .precioVenta(8750D)
                    .precioCompra(5500D)
                    .stockActual(15)
                    .stockMaximo(35)
                    .imagen(imagen1)
                    .unidadMedida(ochoPorc)
                    .build();
            Articulo pizzaGrande2 = Articulo.builder()
                    .denominacion("Pizza Grande Napolitana")
                    .precioVenta(9200D)
                    .precioCompra(5500D)
                    .stockActual(17)
                    .stockMaximo(35)
                    .imagen(imagen2)
                    .unidadMedida(ochoPorc)
                    .build();
            Articulo pizzaGrande3 = Articulo.builder()
                    .denominacion("Pizza Grande Muzza")
                    .precioVenta(7500D)
                    .precioCompra(4600D)
                    .stockActual(30)
                    .stockMaximo(60)
                    .imagen(imagen3)
                    .unidadMedida(ochoPorc)
                    .build();

            Promocion happyHour = Promocion.builder()
                    .denominacion("Promo Happy Hour Septiembre")
                    .fechaDesde(LocalDate.of(2024, 9, 1))
                    .fechaHasta(LocalDate.of(2024, 9, 30))
                    .horaDesde(LocalTime.of(18, 30))
                    .horaHasta(LocalTime.of(21, 30))
                    .descripcionDescuento("Happy Primavera 20%off: Hawaiana 8porc + Muzza 8porc + Quilmes")
                    .tipoPromocion(TipoPromocion.happyHour)
                    .build();

            happyHour.getPromoImagen().add(imaHappy1);
            happyHour.getPromoImagen().add(imaHappy2);
            happyHour.getArticulos().add(pizzaGrande1);
            happyHour.getArticulos().add(pizzaGrande3);
            happyHour.getArticulos().add(cerveza2);
            double precio = 0;
            for (Articulo articulo : happyHour.getArticulos()) {
                precio += articulo.getPrecioVenta();
            }
            happyHour.setPrecioPromocional(precio*0.8);

            Promocion veranoPromo = Promocion.builder()
                    .denominacion("Promo Verano 2024/2025")
                    .fechaDesde(LocalDate.of(2024, 12, 1))
                    .fechaHasta(LocalDate.of(2025, 2, 28))
                    .horaDesde(LocalTime.of(0, 0))
                    .horaHasta(LocalTime.of(23, 59))
                    .descripcionDescuento("Verano hot combo 25%off: Hawaiana chica + Napo grande + Quilmes 1lt + Andes 1lt")
                    .tipoPromocion(TipoPromocion.Verano)
                    .build();
            veranoPromo.getPromoImagen().add(verano1);
            veranoPromo.getPromoImagen().add(verano2);
            veranoPromo.getArticulos().add(pizzaChica1);
            veranoPromo.getArticulos().add(pizzaGrande2);
            veranoPromo.getArticulos().add(cerveza1);
            veranoPromo.getArticulos().add(cerveza2);
            precio = 0;
            for (Articulo articulo : veranoPromo.getArticulos()) {
                precio += articulo.getPrecioVenta();
            }
            veranoPromo.setPrecioPromocional(precio*0.75);

            Promocion inviernoPromo = Promocion.builder()
                    .denominacion("Promo Invierno 2025")
                    .fechaDesde(LocalDate.of(2025, 6, 1))
                    .fechaHasta(LocalDate.of(2025, 8, 31))
                    .horaDesde(LocalTime.of(0, 0))
                    .horaHasta(LocalTime.of(23, 59))
                    .descripcionDescuento("Promos que hielan la sangre 45%off!!!!!!!!!: Hawaiana + Muzza chica + Quilmes 1lt")
                    .tipoPromocion(TipoPromocion.Invierno)
                    .build();
            inviernoPromo.getPromoImagen().add(invierno1);
            inviernoPromo.getPromoImagen().add(invierno2);
            inviernoPromo.getArticulos().add(pizzaGrande1);
            inviernoPromo.getArticulos().add(pizzaChica3);
            inviernoPromo.getArticulos().add(cerveza2);
            precio = 0;
            for (Articulo articulo : inviernoPromo.getArticulos()) {
                precio += articulo.getPrecioVenta();
            }
            inviernoPromo.setPrecioPromocional(precio*0.55);

            entityManager.persist(cerveza1);
            entityManager.persist(cerveza2);
            entityManager.persist(pizzaChica1);
            entityManager.persist(pizzaChica2);
            entityManager.persist(pizzaChica3);
            entityManager.persist(pizzaGrande1);
            entityManager.persist(pizzaGrande2);
            entityManager.persist(pizzaGrande3);

            entityManager.persist(happyHour);
            entityManager.persist(veranoPromo);
            entityManager.persist(inviernoPromo);

            try {
                System.out.println("Guardado correcto, prodeceremos con el desarrollo en 5s");
                pausarPrograma(5);
                for (int i = 0; i < 50; i++) {
                    System.out.println(); //limpiar consola
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Mostrando todas las promociones....");
            pausarPrograma(2);

            double precioPromocion = 0;
            long idPromoEconomica = 0;
            for (Promocion promocion : entityManager.createQuery("SELECT p FROM Promocion p", Promocion.class).getResultList()) {
                System.out.println(promocion.toString());
                if (promocion.getPrecioPromocional() < precioPromocion || idPromoEconomica == 0){
                    precioPromocion = promocion.getPrecioPromocional();
                    idPromoEconomica = promocion.getId();
                }
                pausarPrograma(3);
            }

            for (int i = 0; i < 50; i++) {
                System.out.println(); //limpiar consola
            }

            System.out.println("Mostrando todos los articulos....");
            pausarPrograma(2);

            for (Articulo articulo : entityManager.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList()) {
                System.out.println(articulo.toString());
                pausarPrograma(1);
            }

            for (int i = 0; i < 50; i++) {
                System.out.println(); //limpiar consola
            }

            System.out.println("Mostrando cada promoción por separado, sus articulos relacionados y el precio de venta....");
            pausarPrograma(2);

            System.out.println("Promoción 1:");
            Optional<Promocion> promocionMuestra = Optional.ofNullable(entityManager.find(Promocion.class, 1L));
            promocionMuestra.ifPresent(promocion -> System.out.println(promocion.getDenominacion() +
                    "\n" + promocion.getDescripcionDescuento() +
                    "\n" + "Articulos: " + getCadenaArticulos(promocion.getArticulos()) +
                    "\n" + "Precio: " + promocion.getPrecioPromocional()));
            pausarPrograma(4);
            for (int i = 0; i < 50; i++) {
                System.out.println(); //limpiar consola
            }

            System.out.println("Promoción 2:");
            promocionMuestra = Optional.ofNullable(entityManager.find(Promocion.class, 2L));
            promocionMuestra.ifPresent(promocion -> System.out.println(promocion.getDenominacion() +
                    "\n" + promocion.getDescripcionDescuento() +
                    "\n" + "Articulos: " + getCadenaArticulos(promocion.getArticulos()) +
                    "\n" + "Precio: " + promocion.getPrecioPromocional()));
            pausarPrograma(4);
            for (int i = 0; i < 50; i++) {
                System.out.println(); //limpiar consola
            }

            System.out.println("Promoción 3:");
            promocionMuestra = Optional.ofNullable(entityManager.find(Promocion.class, 3L));
            promocionMuestra.ifPresent(promocion -> System.out.println(promocion.getDenominacion() +
                    "\n" + promocion.getDescripcionDescuento() +
                    "\n" + "Articulos: " + getCadenaArticulos(promocion.getArticulos()) +
                    "\n" + "Precio: " + promocion.getPrecioPromocional()));
            pausarPrograma(4);
            for (int i = 0; i < 50; i++) {
                System.out.println(); //limpiar consola
            }

            System.out.println("Mostrando el dia y horario de la promoción verano....");
            pausarPrograma(2);

            Optional<Promocion> promoVerano = Optional.ofNullable(entityManager.find(Promocion.class, 2L));
            promoVerano.ifPresent(promocion -> System.out.println(promocion.getDenominacion() +
                    "\nDesde: " + promocion.getFechaDesde() +
                    "\nHasta: " + promocion.getFechaHasta() +
                    "\nHora inicio: " + promocion.getHoraDesde() +
                    "\nHora fin: " + promocion.getHoraHasta()));
            pausarPrograma(4);
            for (int i = 0; i < 50; i++) {
                System.out.println(); //limpiar consola
            }

            System.out.println("Mostrando la promoción más económica....");
            pausarPrograma(2);

            Optional.ofNullable(entityManager.find(Promocion.class, idPromoEconomica)).ifPresent(promocion -> {
                System.out.println("La promoción más económica es: " + promocion.getDenominacion() +
                        "\nPrecio: $" + promocion.getPrecioPromocional());
            });
            pausarPrograma(5);

            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public static void pausarPrograma(int segundos) {
        try {
            Thread.sleep(1000L * segundos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getCadenaArticulos(Set<Articulo> articuloSet) {
        StringBuilder cadenaArticulos = new StringBuilder();
        for (Articulo articulo : articuloSet) {
            cadenaArticulos.append(articulo.getDenominacion()).append(" | ");
        }
        return cadenaArticulos.toString();
    }
}
