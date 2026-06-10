package modelo;

public class PuestoDesarmable extends UnidadDeVenta {
	private int cantidadCarpas;
	private int tiempoMontaje;

	public PuestoDesarmable(int idUnidad, String nombreComercial, float superficie,
			String codigoUnico, Staff responsable,int cantidadCarpas, int tiempoMontaje) {
		super(idUnidad, nombreComercial, superficie, codigoUnico, responsable);
		this.cantidadCarpas = cantidadCarpas;
		this.tiempoMontaje = tiempoMontaje;
	}

	public int getCantidadCarpas() {
		return cantidadCarpas;
	}

	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}

	public int getTiempoMontaje() {
		return tiempoMontaje;
	}

	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}
	
	@Override
	public float calcularCanon(Costo costo) {
		float canon = 0;

		canon = (superficie * costo.getCostoSuperficie());

		canon -= (tiempoMontaje * costo.getCostoMontaje());

		return canon;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable" + super.toString() + "[cantidadCarpas="
				+ cantidadCarpas + ", tiempoMontaje=" + tiempoMontaje + "]";
	}
}
