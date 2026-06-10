package modelo;

import java.time.LocalDate;

public class Cajero extends Staff {
	private String turno;

	public Cajero(int idStaff, String nombre, String apellido, long dni,
			LocalDate fechaNacimiento, LocalDate fechaIngreso, String turno) {
		super(idStaff, nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		this.turno = turno;
	}


	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	@Override
	public float calcularHaberes(Costo costo) {
		return costo.getSueldoBase() + (calcularAntiguedad() * 5000);
	}

	@Override
	public String toString() {
		return "Cajero" + super.toString() + "[turno=" + turno + "]";
	}
}
