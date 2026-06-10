package modelo;

public class Costo {
	private int idCosto;
	private float costoSuperficie;
	private float costoMontaje;
	private float plusElectricidad;
	private float sueldoBase;

	public Costo(int idCosto, float costoSuperficie, float costoMontaje, float plusElectricidad,
			float sueldoBase) {
		super();
		this.idCosto = idCosto;
		this.costoSuperficie = costoSuperficie;
		this.costoMontaje = costoMontaje;
		this.plusElectricidad = plusElectricidad;
		this.sueldoBase = sueldoBase;
	}

	public int getIdCosto() {
		return idCosto;
	}

	public void setIdCosto(int idCosto) {
		this.idCosto = idCosto;
	}

	public float getCostoSuperficie() {
		return costoSuperficie;
	}

	public void setCostoSuperficie(float costoSuperficie) {
		this.costoSuperficie = costoSuperficie;
	}

	public float getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(float costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public float getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(float plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	@Override
	public String toString() {
		return "Costo [idCosto=" + idCosto + ", costoSuperficie=" + costoSuperficie + ", costoMontaje="
				+ costoMontaje + ", plusElectricidad=" + plusElectricidad + ", sueldoBase=" + sueldoBase + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costo other = (Costo) obj;
		return idCosto == other.idCosto;
	}
}
