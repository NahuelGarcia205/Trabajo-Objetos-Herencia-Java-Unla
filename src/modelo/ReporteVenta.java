package modelo;

public class ReporteVenta {
	private UnidadDeVenta unidadDeVenta;
	private float recaudacionTotal;

	public ReporteVenta(UnidadDeVenta unidadDeVenta, float recaudacionTotal) {
		super();
		this.unidadDeVenta = unidadDeVenta;
		this.recaudacionTotal = recaudacionTotal;
	}

	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	public float getRecaudacionTotal() {
		return recaudacionTotal;
	}

	public void setRecaudacionTotal(float recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}

	@Override
	public String toString() {
		return "ReporteVenta [unidadDeVenta=" + unidadDeVenta
				+ ", recaudacionTotal=" + recaudacionTotal + "]";
	}
}
