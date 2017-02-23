package dao;

import java.sql.Date;
import java.util.Random;

public class Ciudadano {

	private String nombre, apellidos, email, direccion, nacionalidad, dni, password;
	private Date fecha_nacimiento;

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

	/**
	 * Metodo para crear la password de forma aleatoria.
	 */
	public void crearPassword() {
		password = "";
		char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] mayusculas = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
		char[] numeros = "0123456789".toCharArray();
		char[] simbolos = "'¿?*+-$%".toCharArray();
		
		// Tiene una letra mayuscula
		Random random = new Random();
		int pos = random.nextInt(mayusculas.length);
		password += mayusculas[pos];
		
		// Tiene 5 letras minusculas
		for (int i = 0; i < 5; i++) {
			random = new Random();
			pos = random.nextInt(minusculas.length);
			password += minusculas[pos];
		}
		
		// Tiene un numero
		random = new Random();
		pos = random.nextInt(numeros.length);
		password += numeros[pos];
		
		// Tiene un simbolo especial 
		random = new Random();
		pos = random.nextInt(simbolos.length);
		password += simbolos[pos];
	}
}