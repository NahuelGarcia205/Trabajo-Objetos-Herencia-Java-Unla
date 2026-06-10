package modelo;

import java.time.LocalDate;

public class Cocinero extends Staff {
	private String especialidad;
	private float plusCategoria;

	public Cocinero(int idStaff, String nombre, String apellido, long dni,
			LocalDate fechaNacimiento,LocalDate fechaIngreso, String especialidad, float plusCategoria) {
		super(idStaff, nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}


	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public float getPlusCategoria() {
		return plusCategoria;
	}

	public void setPlusCategoria(float plusCategoria) {
		this.plusCategoria = plusCategoria;
	}
	
	@Override
	public float calcularHaberes(Costo costo) {
		return costo.getSueldoBase() + plusCategoria;
	}

	@Override
	public String toString() {
		return "Cocinero" + super.toString() + "[especialidad=" + especialidad + ", plusCategoria=" + plusCategoria + "]";
	}
}
