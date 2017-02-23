package dao;

import java.sql.Date;

public class Ciudadano {

	private String nombre, apellidos, email, direccion, nacionalidad, dni, password;
	private Date fecha_nacimiento;

	/*
	 * AÑADIR NORMAS DE FORMATO EJ: DNI DEBE TENER 8 NUMEROS + LETRA
	 * 
	 * 
	 * 
	 */

	public Ciudadano(String nombre, String apellidos, String email, String direccion, String nacionalidad, String dni,
			Date fecha_nacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Ciudadano [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", direccion="
				+ direccion + ", nacionalidad=" + nacionalidad + ", dni=" + dni + ", password=" + password
				+ ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}

}