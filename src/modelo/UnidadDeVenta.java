package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class UnidadDeVenta {
	protected int idUnidad;
	protected String nombreComercial;
	protected float superficie;
	protected String codigoUnico;
	protected Staff responsable;
	protected List<Staff> lstStaffs;
	protected List<Plato> lstPlatos;
	protected List<Pedido> lstPedidos;

	public UnidadDeVenta(int idUnidad, String nombreComercial, float superficie,
			String codigoUnico, Staff responsable) {
		super();
		this.idUnidad = idUnidad;
		this.nombreComercial = nombreComercial;
		this.superficie = superficie;
		this.codigoUnico = codigoUnico;
		this.responsable = responsable;
		this.lstStaffs = new ArrayList<Staff>();
		this.lstPlatos = new ArrayList<Plato>();
		this.lstPedidos = new ArrayList<Pedido>();
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

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public Staff getResponsable() {
		return responsable;
	}

	public void setResponsable(Staff responsable) {
		this.responsable = responsable;
	}

	public List<Staff> getLstStaff() {
		return lstStaffs;
	}

	public List<Plato> getLstPlatos() {
		return lstPlatos;
	}

	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}

	@Override
	public String toString() {
		return " [idUnidad=" + idUnidad + ", nombreComercial=" + nombreComercial
				+ ", superficie=" + superficie + ", codigoUnico=" + codigoUnico
				+ ", responsable=" + responsable + "]";
	}
	
	public boolean agregarStaff(Staff staff) {
		return lstStaffs.add(staff);
	}

	public boolean agregarPlato(Plato plato) {
		return lstPlatos.add(plato);
	}

	public boolean agregarPedido(Pedido pedido) {
		return lstPedidos.add(pedido);
	}

	public Pedido traerPedido(int idPedido) {
		Pedido encontrado = null;

		int i = 0;
		while(i < lstPedidos.size() && encontrado == null) {
			if(lstPedidos.get(i).getIdPedido() == idPedido) {
				encontrado = lstPedidos.get(i);
			}
			i++;
		}
		return encontrado;
	}

	public float calcularRecaudacion() {
		float total = 0;
		for(Pedido p : lstPedidos) {
			total += p.calcularTotal();
		}
		return total;
	}

	public float calcularRentabilidadNeta(Costo costo) {
		float ganancias = calcularRecaudacion();
		float costosPlatos = 0;
		for(Pedido p : lstPedidos) {
			for(ItemPedido i : p.getListaItemPedido()) {
				costosPlatos += i.getPlato().getCostoProduccion()
						* i.getCantidad();
			}
		}

		float sueldos = 0;
		for(Staff s : lstStaffs) {
			sueldos += s.calcularHaberes(costo);
		}
		return ganancias - costosPlatos - sueldos - calcularCanon(costo);
	}

	public float calcularRentabilidadNetaEntreFechas(LocalDate f1,LocalDate f2, Costo costo) {
		float ganancias = 0;
		float costosPlatos = 0;
		for(Pedido p : lstPedidos) {

			if((!p.getFecha().isBefore(f1) && !p.getFecha().isAfter(f2))) {
				ganancias += p.calcularTotal();
				for(ItemPedido i : p.getListaItemPedido()) {
					costosPlatos += i.getPlato().getCostoProduccion()
							* i.getCantidad();
				}
			}
		}

		float sueldos = 0;
		for(Staff s : lstStaffs) {
			sueldos += s.calcularHaberes(costo);
		}
		return ganancias - costosPlatos - sueldos - calcularCanon(costo);
	}

	public Plato traerPlatoEstrella(int idFestival) {
		Plato estrella = null;
		int maxCantidad = 0;
		for(Plato p : lstPlatos) {
			int cantidadTotal = 0;
			for(Pedido pedido : lstPedidos) {
				if(pedido.getFestival().getIdFestival() == idFestival) {
					for(ItemPedido item : pedido.getListaItemPedido()) {
						if(item.getPlato().equals(p)) {
							cantidadTotal += item.getCantidad();
						}
					}
				}
			}

			if(cantidadTotal > maxCantidad) {
				maxCantidad = cantidadTotal;
				estrella = p;
			}
		}

		return estrella;
	}

	public abstract float calcularCanon(Costo costo);
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadDeVenta other = (UnidadDeVenta) obj;
		return codigoUnico.equals(other.codigoUnico);
	}
}
