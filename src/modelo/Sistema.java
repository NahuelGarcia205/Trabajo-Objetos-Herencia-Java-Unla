package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sistema {
	private List<UnidadDeVenta> lstUnidades;
	private List<Festival> lstFestivales;
	private List<Staff> lstStaffs;

	public Sistema() {
		super();
		this.lstUnidades = new ArrayList<UnidadDeVenta>();
		this.lstFestivales = new ArrayList<Festival>();
		this.lstStaffs = new ArrayList<Staff>();
	}

	public List<UnidadDeVenta> getUnidades() {
		return lstUnidades;
	}

	public List<Festival> getFestivales() {
		return lstFestivales;
	}

	public List<Staff> getStaff() {
		return lstStaffs;
	}
	
	public Festival traerFestival(int idFestival) {
		Festival encontrado = null;
		int i = 0;
		while(i < lstFestivales.size() && encontrado == null) {
			if(lstFestivales.get(i).getIdFestival() == idFestival) {
				encontrado = lstFestivales.get(i);
			}
			i++;
		}
		return encontrado;
	}

	public boolean agregarFestival(String nombre, String temporada, LocalDate fechaInicio,
			LocalDate fechaFin, Costo costosLocales) {
		int id = 1;
		if(!lstFestivales.isEmpty()) {
			id = lstFestivales.get(lstFestivales.size()-1).getIdFestival()+1;
		}

		return lstFestivales.add(new Festival(id, nombre, temporada, fechaInicio, fechaFin, costosLocales));
	}
	
	public boolean eliminarFestival(int idFestival) {
		Festival encontrado = traerFestival(idFestival);

		if(encontrado == null) {
			return false;
		}

		return lstFestivales.remove(encontrado);
	}

	public boolean agregarFoodTruck(String nombreComercial, float superficie,String codigoUnico, Staff responsable,
			String patente, boolean conexionElectrica) {
		if(traerUnidad(codigoUnico) != null) {
			throw new IllegalArgumentException("Error: ya existe unidad con ese codigo");
		}
		
		int id = 1;
		if(!lstUnidades.isEmpty()) {
			id = lstUnidades.get(lstUnidades.size()-1).getIdUnidad()+1;
		}
		return lstUnidades.add(new FoodTruck(id,nombreComercial,superficie,codigoUnico,responsable,patente,conexionElectrica)
		);
	}

	public boolean agregarPuestoDesarmable(String nombreComercial, float superficie,
			String codigoUnico, Staff responsable,int cantidadCarpas, int tiempoMontaje) {

		if(traerUnidad(codigoUnico) != null) {
			throw new IllegalArgumentException("Error: ya existe unidad con ese codigo");
		}
		
		int id = 1;
		if(!lstUnidades.isEmpty()) {
			id = lstUnidades.get(lstUnidades.size()-1).getIdUnidad()+1;
		}
		return lstUnidades.add(new PuestoDesarmable(id,nombreComercial, superficie,
			 codigoUnico,  responsable, cantidadCarpas,  tiempoMontaje));
	}
	
	public boolean eliminarUnidad(String codigoUnico) {
		UnidadDeVenta encontrado = traerUnidad(codigoUnico);

		if(encontrado == null) {
			return false;
		}

		return lstUnidades.remove(encontrado);
	}

	public boolean agregarCocinero(String nombre, String apellido, long dni,
			LocalDate fechaNacimiento,LocalDate fechaIngreso, String especialidad, float plusCategoria) {
		if(traerStaff(dni) != null) {
			throw new IllegalArgumentException("Error: ya existe staff con ese dni");
		}

		int id = 1;
		if(!lstStaffs.isEmpty()) {
			id = lstStaffs.get(lstStaffs.size()-1).getIdStaff()+1;
		}

		return lstStaffs.add(new Cocinero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, especialidad, plusCategoria));
	}


	public boolean agregarCajero(String nombre, String apellido, long dni,
			LocalDate fechaNacimiento, LocalDate fechaIngreso, String turno) {

		if(traerStaff(dni) != null) {
			throw new IllegalArgumentException("Error: ya existe staff con ese dni");
		}

		int id = 1;
		if(!lstStaffs.isEmpty()) {
			id = lstStaffs.get(lstStaffs.size()-1).getIdStaff()+1;
		}
		return lstStaffs.add(new Cajero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, turno));
	}


	public Staff traerStaff(long dni) {
		Staff encontrado = null;
		int i = 0;
		while(i< lstStaffs.size() && encontrado == null) {
			if(lstStaffs.get(i).getDni() == dni) {
				encontrado = lstStaffs.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public boolean eliminarStaff(long dni) {
		Staff encontrado = traerStaff(dni);

		if(encontrado == null) {
			return false;
		}

		return lstStaffs.remove(encontrado);
	}


	public List<Staff> traerAuditoriaPersonal(int idFestival){
		List<Staff> listaFiltrada = new ArrayList<Staff>();
		Festival festival = traerFestival(idFestival);
		if(festival != null) {
			for(UnidadDeVenta u : festival.getLstUnidadesDeVentas()) {
				for(Staff s : u.getLstStaff()) {
					if(!listaFiltrada.contains(s)) {
						listaFiltrada.add(s);
					}
				}
			}
		}
		return listaFiltrada;
	}


	public UnidadDeVenta traerUnidad(String codigoUnico) {
		UnidadDeVenta encontrado = null;
		int i = 0;
		while(i < lstUnidades.size() && encontrado == null) {
			if(lstUnidades.get(i).getCodigoUnico().equalsIgnoreCase(codigoUnico)) {
				encontrado = lstUnidades.get(i);
			}
			i++;
		}
		return encontrado;
	}


	public List<Staff> traerPersonalNacidoEntreFechas(LocalDate f1, LocalDate f2){
		List<Staff> listaFiltrada = new ArrayList<Staff>();
		for(Staff s : lstStaffs) {
			if(!s.getFechaNacimiento().isBefore(f1) && !s.getFechaNacimiento().isAfter(f2)) {
				listaFiltrada.add(s);
			}
		}
		return listaFiltrada;
	}

	public List<ReporteVenta> reporteRecaudacion(int idFestival){
		List<ReporteVenta> listaReporte = new ArrayList<ReporteVenta>();
		Festival festival = traerFestival(idFestival);
		if(festival != null) {
			for(UnidadDeVenta u : festival.getLstUnidadesDeVentas()) {
				listaReporte.add(new ReporteVenta(u,u.calcularRecaudacion()));
			}
		}
		return listaReporte;
	}

	public List<UnidadDeVenta> rankearUnidades(){
		List<UnidadDeVenta> listaOrdenada =new ArrayList<UnidadDeVenta>(lstUnidades);
		listaOrdenada.sort(Comparator.comparing(UnidadDeVenta::calcularRecaudacion).reversed());
		return listaOrdenada;
	}


	public List<ReporteMayoresCanon> generarReporteMayoresCanon(int idFestival){
		List<ReporteMayoresCanon> listaReporte =new ArrayList<ReporteMayoresCanon>();
		Festival festival = traerFestival(idFestival);
		if(festival != null) {
			List<UnidadDeVenta> listaOrdenada =new ArrayList<UnidadDeVenta>(festival.getLstUnidadesDeVentas());
			listaOrdenada.sort(Comparator.comparing((UnidadDeVenta u) -> u.calcularCanon(festival.getCostosLocales())).reversed());	
			
			for(int i=0; i<3 && i<listaOrdenada.size(); i++) {
				UnidadDeVenta u = listaOrdenada.get(i);
				listaReporte.add(new ReporteMayoresCanon(u.getIdUnidad(),u.getNombreComercial(),u.getClass().getSimpleName(),
						u.calcularCanon(festival.getCostosLocales())));
			}
		}

		return listaReporte;
	}
	
	@Override
	public String toString() {
		return "Sistema [unidades=" + lstUnidades + ", festivales="
				+ lstFestivales + ", staff=" + lstStaffs + "]";
	}

}
