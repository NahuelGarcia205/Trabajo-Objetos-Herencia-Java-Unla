package modelo;

public class Plato {
	private int idPlato;
	private String nombre;
	private float precioVenta;
	private float costoProduccion;

	public Plato(int idPlato, String nombre, float precioVenta, float costoProduccion) {
		super();
		this.idPlato = idPlato;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre
				+ ", precioVenta=" + precioVenta + ", costoProduccion="
				+ costoProduccion + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		return idPlato == other.idPlato;
	}
}
