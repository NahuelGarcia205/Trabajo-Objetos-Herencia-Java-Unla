package test;

import java.time.LocalDate;

import modelo.*;

public class TestFestival {

	public static void main(String[] args) {

		Sistema sistema = new Sistema();
		System.out.println("------ [ 1 ] COSTOS ------");
		Costo costo = new Costo(1, 500, 10, 2000, 100000);

		System.out.println(costo);
		System.out.println("\n------ [ 2 ] AGREGAR STAFF ------");

		try {
			sistema.agregarCocinero("Juan", "Perez", 11111111, LocalDate.of(1990, 5, 10), LocalDate.of(2020, 1, 5),
					"Parrilla", 25000);
			sistema.agregarCocinero("Ana", "Lopez", 22222222, LocalDate.of(1995, 8, 15), LocalDate.of(2021, 6, 10),
					"Pastas", 18000);
			sistema.agregarCajero("Lucas", "Martinez", 33333333, LocalDate.of(1988, 4, 20), LocalDate.of(2018, 3, 1),
					"Mañana");
			sistema.agregarCajero("Sofia", "Gomez", 44444444, LocalDate.of(1992, 9, 12), LocalDate.of(2019, 7, 15),
					"Noche");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Staff s : sistema.getStaff()) {
			System.out.println(s);
		}

		Cocinero c1 = (Cocinero) sistema.traerStaff(11111111);
		Cocinero c2 = (Cocinero) sistema.traerStaff(22222222);
		Cajero ca1 = (Cajero) sistema.traerStaff(33333333);
		Cajero ca2 = (Cajero) sistema.traerStaff(44444444);

		System.out.println("\n------ [ 3 ] AGREGAR UNIDADES ------");

		try {
			sistema.agregarFoodTruck("BurgerMax", 40, "FT12345678", c1, "AA123BB", true);
			sistema.agregarFoodTruck("PizzaRoad", 35, "FT87654321", c2, "CC456DD", false);
			sistema.agregarPuestoDesarmable("TacoPoint", 60, "PD11112222", ca1, 4, 120);
			sistema.agregarPuestoDesarmable("DulceTentacion", 45, "PD33334444", ca2, 2, 80);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (UnidadDeVenta u : sistema.getUnidades()) {
			System.out.println(u);
		}

		UnidadDeVenta u1 = sistema.traerUnidad("FT12345678");
		UnidadDeVenta u2 = sistema.traerUnidad("FT87654321");
		UnidadDeVenta u3 = sistema.traerUnidad("PD11112222");
		UnidadDeVenta u4 = sistema.traerUnidad("PD33334444");

		System.out.println("\n------ [ 4 ] AGREGAR FESTIVALES ------");

		try {
			sistema.agregarFestival("Festival Gourmet", "Verano", LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 20),
					costo);
			sistema.agregarFestival("Festival Callejero", "Invierno", LocalDate.of(2026, 7, 5),
					LocalDate.of(2026, 7, 12), costo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (Festival f : sistema.getFestivales()) {
			System.out.println(f);
		}

		Festival f1 = sistema.traerFestival(1);
		Festival f2 = sistema.traerFestival(2);

		System.out.println("\n------ [ 5 ] AGREGAR UNIDADES A FESTIVALES ------");

		f1.agregarUnidadDeVenta(u1);
		f1.agregarUnidadDeVenta(u2);

		f2.agregarUnidadDeVenta(u3);
		f2.agregarUnidadDeVenta(u4);

		for (UnidadDeVenta u : f1.getLstUnidadesDeVentas()) {
			System.out.println(u);
		}
		System.out.println("\n------ [ 6 ] AGREGAR STAFF A UNIDADES ------");
		u1.agregarStaff(c1);
		u1.agregarStaff(ca1);
		u2.agregarStaff(c2);
		u3.agregarStaff(ca2);
		u4.agregarStaff(c1);

		for (Staff s : u1.getLstStaff()) {
			System.out.println(s);
		}

		System.out.println("\n------ [ 7 ] AGREGAR PLATOS ------");
		Plato p1 = new Plato(1, "Hamburguesa", 8000, 3500);
		Plato p2 = new Plato(2, "Pizza", 12000, 5000);
		Plato p3 = new Plato(3, "Taco", 5000, 2000);
		Plato p4 = new Plato(4, "Helado", 3000, 1000);

		u1.agregarPlato(p1);
		u1.agregarPlato(p2);
		u2.agregarPlato(p2);
		u3.agregarPlato(p3);
		u4.agregarPlato(p4);

		for (Plato p : u1.getLstPlatos()) {
			System.out.println(p);
		}

		System.out.println("\n------ [ 8 ] AGREGAR PEDIDOS ------");
		Pedido pe1 = new Pedido(1, LocalDate.of(2026, 1, 12), f1, u1);
		pe1.agregarItem(p1, 5);
		pe1.agregarItem(p2, 2);
		u1.agregarPedido(pe1);

		Pedido pe2 = new Pedido(2, LocalDate.of(2026, 1, 13), f1, u1);
		pe2.agregarItem(p1, 3);
		u1.agregarPedido(pe2);

		Pedido pe3 = new Pedido(3, LocalDate.of(2026, 7, 8), f2, u3);
		pe3.agregarItem(p3, 10);
		u3.agregarPedido(pe3);

		for (Pedido p : u1.getLstPedidos()) {
			System.out.println(p);
		}

		System.out.println("\n------ [ 9 ] TRAER STAFF ------");
		System.out.println(sistema.traerStaff(11111111));
		System.out.println("\n------ [ 10 ] TRAER UNIDAD ------");
		System.out.println(sistema.traerUnidad("FT12345678"));
		System.out.println("\n------ [ 11 ] REPORTE RECAUDACION ------");

		for (ReporteVenta r : sistema.reporteRecaudacion(1)) {
			System.out.println(r);
		}

		System.out.println("\n------ [ 12 ] RANKING UNIDADES ------");
		for (UnidadDeVenta u : sistema.rankearUnidades()) {
			System.out.println(u.getNombreComercial() + " -> " + u.calcularRecaudacion());
		}

		System.out.println("\n------ [ 13 ] PLATO ESTRELLA ------");
		System.out.println(u1.traerPlatoEstrella(1));
		System.out.println("\n------ [ 14 ] AUDITORIA PERSONAL ------");

		for (Staff s : sistema.traerAuditoriaPersonal(1)) {
			System.out.println(s);
		}

		System.out.println("\n------ [ 15 ] PERSONAL ENTRE FECHAS ------");
		for (Staff s : sistema.traerPersonalNacidoEntreFechas(LocalDate.of(1989, 1, 1), LocalDate.of(1996, 12, 31))) {
			System.out.println(s);
		}

		System.out.println("\n------ [ 16 ] CALCULAR CANON ------");
		System.out.println(u1.calcularCanon(costo));
		System.out.println(u3.calcularCanon(costo));

		System.out.println("\n------ [ 17 ] RENTABILIDAD NETA ------");
		System.out.println(u1.calcularRentabilidadNeta(costo));

		System.out.println("\n------ [ 18 ] RENTABILIDAD ENTRE FECHAS ------");
		System.out.println(u1.calcularRentabilidadNetaEntreFechas(LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 15), costo));

		System.out.println("\n------ [ 19 ] MAYORES CANON ------");
		for (ReporteMayoresCanon r : sistema.generarReporteMayoresCanon(1)) {
			System.out.println(r);
		}

		System.out.println("\n------ [ 20 ] ELIMINAR STAFF ------");
		sistema.eliminarStaff(44444444);
		for (Staff s : sistema.getStaff()) {
			System.out.println(s);
		}

		System.out.println("\n------ [ 21 ] ELIMINAR UNIDAD ------");
		sistema.eliminarUnidad("PD33334444");
		for (UnidadDeVenta u : sistema.getUnidades()) {
			System.out.println(u);
		}

		System.out.println("\n------ [ 22 ] ELIMINAR FESTIVAL ------");
		sistema.eliminarFestival(2);
		for (Festival f : sistema.getFestivales()) {
			System.out.println(f);
		}

		System.out.println("\n------ [ 23 ] VALIDACION REPETIDO ------");
		try {
			sistema.agregarCajero("Repetido", "Error", 11111111, LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1),
					"Noche");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
