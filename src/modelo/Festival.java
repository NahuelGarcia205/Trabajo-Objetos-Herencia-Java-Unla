package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Festival {
	private int idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Costo costosLocales;
	private List<UnidadDeVenta> lstUnidadesDeVentas;

	public Festival(int idFestival, String nombre, String temporada, LocalDate fechaInicio,
			LocalDate fechaFin, Costo costosLocales) {
		super();
		this.idFestival = idFestival;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costosLocales = costosLocales;
		this.lstUnidadesDeVentas = new ArrayList<UnidadDeVenta>();
	}

	public int getIdFestival() {
		return idFestival;
	}

	public void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Costo getCostosLocales() {
		return costosLocales;
	}

	public void setCostosLocales(Costo costosLocales) {
		this.costosLocales = costosLocales;
	}

	public List<UnidadDeVenta> getLstUnidadesDeVentas() {
		return lstUnidadesDeVentas;
	}

	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costosLocales="
				+ costosLocales + ", unidadesDeVentas=" + lstUnidadesDeVentas + "]";
	}
	
	public UnidadDeVenta traerUnidadDeVenta(String codigoUnico) {
		UnidadDeVenta encontrado = null;
		int i = 0;

		while(i < lstUnidadesDeVentas.size() && encontrado == null) {
			if(lstUnidadesDeVentas.get(i).getCodigoUnico().equalsIgnoreCase(codigoUnico)) {
				encontrado = lstUnidadesDeVentas.get(i);
			}
			i++;
		}

		return encontrado;
	}
	
	public boolean agregarUnidadDeVenta(UnidadDeVenta unidad) {

		if(traerUnidadDeVenta(unidad.getCodigoUnico()) != null) {
			throw new IllegalArgumentException("Error: ya existe una unidad con ese codigo en el festival");
		}

		return lstUnidadesDeVentas.add(unidad);
	}
	
	public boolean eliminarUnidadDeVenta(String codigoUnico) {
		UnidadDeVenta encontrado = traerUnidadDeVenta(codigoUnico);

		if(encontrado == null) {
			return false;
		}

		return lstUnidadesDeVentas.remove(encontrado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		return idFestival == other.idFestival;
	}
}
