package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int idPedido;
	private LocalDate fecha;
	private Festival festival;
	private UnidadDeVenta unidadDeVenta;
	private List<ItemPedido> listaItemPedido;

	public Pedido(int idPedido, LocalDate fecha, Festival festival,
			UnidadDeVenta unidadDeVenta) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.festival = festival;
		this.unidadDeVenta = unidadDeVenta;
		this.listaItemPedido = new ArrayList<ItemPedido>();
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	public List<ItemPedido> getListaItemPedido() {
		return listaItemPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha
				+ ", festival=" + festival + ", unidadDeVenta="
				+ unidadDeVenta + "]";
	}
	
	public boolean agregarItem(Plato p, int cantidad) {
		if(cantidad <= 0) {
			throw new IllegalArgumentException("Error: cantidad invalida");
		}

		int id = 1;

		if(!listaItemPedido.isEmpty()) {
			id = listaItemPedido.get(listaItemPedido.size()-1).getIdItem()+1;
		}

		return listaItemPedido.add(new ItemPedido(id, p, cantidad));
	}
	
	public ItemPedido traerItem(int idItem) {
		ItemPedido encontrado = null;

		int i = 0;

		while(i < listaItemPedido.size() && encontrado == null) {
			if(listaItemPedido.get(i).getIdItem() == idItem) {
				encontrado = listaItemPedido.get(i);
			}
			i++;
		}

		return encontrado;
	}
	
	public boolean eliminarItem(Plato p, int cantidad) {
		ItemPedido encontrado = null;

		int i = 0;

		while(i < listaItemPedido.size() && encontrado == null) {

			if(listaItemPedido.get(i).getPlato().equals(p)
					&& listaItemPedido.get(i).getCantidad() == cantidad) {

				encontrado = listaItemPedido.get(i);
			}

			i++;
		}

		if(encontrado == null) {
			return false;
		}

		return listaItemPedido.remove(encontrado);
	}
	
	public float calcularTotal() {
		float total = 0;

		for(ItemPedido i : listaItemPedido) {
			total += i.calcularSubTotal();
		}

		return total;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}
}
