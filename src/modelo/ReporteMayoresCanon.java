package modelo;


public class ReporteMayoresCanon {
	private int idUnidad;
	private String nombreComercial;
	private String tipoUnidad;
	private float canon;
	
	public ReporteMayoresCanon(int idUnidad, String nombreComercial, String tipoUnidad, float canon) {
		super();
		this.idUnidad = idUnidad;
		this.nombreComercial = nombreComercial;
		this.tipoUnidad = tipoUnidad;
		this.canon = canon;
	}

	public int getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public float getCanon() {
		return canon;
	}

	public void setCanon(float canon) {
		this.canon = canon;
	}

	@Override
	public String toString() {
		return "reporteMayoresCanon [idUnidad=" + idUnidad + ", nombreComercial=" + nombreComercial + ", tipoUnidad="
				+ tipoUnidad + ", canon=" + canon + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReporteMayoresCanon other = (ReporteMayoresCanon) obj;
		return idUnidad == other.idUnidad;
	}
	
	

}
