package modelo;

import java.time.LocalDate;
import java.time.Period;

public abstract class Staff {
	protected int idStaff;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;

	public Staff(int idStaff, String nombre, String apellido, long dni,
			LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		super();
		this.idStaff = idStaff;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return " [idStaff=" + idStaff + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaIngreso=" + fechaIngreso + "]";
	}
	
	public int calcularAntiguedad() {
		return Period.between(fechaIngreso, LocalDate.now()).getYears();
	}

	public abstract float calcularHaberes(Costo costo);

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return dni == other.dni;
	}
}