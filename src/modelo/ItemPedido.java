package modelo;

public class ItemPedido {
	private int idItem;
	private Plato plato;
	private int cantidad;

	public ItemPedido(int idItem, Plato plato, int cantidad) {
		super();
		this.idItem = idItem;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItem=" + idItem + ", plato=" + plato
				+ ", cantidad=" + cantidad + "]";
	}
	
	public float calcularSubTotal() {
		return plato.getPrecioVenta() * cantidad;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return idItem == other.idItem;
	}
}
