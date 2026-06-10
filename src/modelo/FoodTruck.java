package modelo;

public class FoodTruck extends UnidadDeVenta {
	private String patente;
	private boolean conexionElectrica;

	public FoodTruck(int idUnidad, String nombreComercial, float superficie,String codigoUnico, Staff responsable,
			String patente, boolean conexionElectrica) {
		super(idUnidad, nombreComercial, superficie, codigoUnico, responsable);
		this.patente = patente;
		this.conexionElectrica = conexionElectrica;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isConexionElectrica() {
		return conexionElectrica;
	}

	public void setConexionElectrica(boolean conexionElectrica) {
		this.conexionElectrica = conexionElectrica;
	}

	@Override
	public float calcularCanon(Costo costo) {
		float canon = 0;

		canon = (superficie * costo.getCostoSuperficie());

		if(conexionElectrica == true) {
			canon += costo.getPlusElectricidad();
		}

		return canon;
	}
	
	@Override
	public String toString() {
		return "FoodTruck" + super.toString() + "[patente=" + patente
				+ ", conexionElectrica=" + conexionElectrica + "]";
	}
}
