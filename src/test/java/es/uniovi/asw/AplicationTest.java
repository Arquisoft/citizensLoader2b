package es.uniovi.asw;

import static org.junit.Assert.*;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.Ciudadano;

public class AplicationTest {
	@SuppressWarnings("deprecation")
	@Test
	public void addCiudadanoTest() {
		List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
		
		Ciudadano c = new Ciudadano("Pepe", "Garcia", "email@prueba", "dir", "España", "564613I", new Date(1995-1900,2,25));
		ciudadanos.add(c);
		BBDD.insertarCiudadano(ciudadanos);
		
		Ciudadano cBD = BBDD.obtenerCiudadano("564613I");
		assertNotNull(cBD);
		assertEquals("Pepe", cBD.getNombre());
		assertEquals("Garcia",cBD.getApellidos());
		assertEquals("email@prueba",cBD.getEmail());
		assertEquals("dir",cBD.getDireccion());
		assertEquals("España",cBD.getNacionalidad());
		assertEquals("564613I",cBD.getDni());
		assertEquals(new Date(1995-1900,2,25),cBD.getFecha_nacimiento());
		
		c.setDireccion("direccion2");
		c.setEmail("otroemail@.com");
		c.setApellidos("Garcia Garcia");
		
		BBDD.updateCiudadano(c);
		cBD = BBDD.obtenerCiudadano("564613I");
		assertNotNull(cBD);
		assertEquals("Pepe", cBD.getNombre());
		assertEquals("Garcia Garcia",cBD.getApellidos());
		assertEquals("otroemail@.com",cBD.getEmail());
		assertEquals("direccion2",cBD.getDireccion());
		assertEquals("España",cBD.getNacionalidad());
		assertEquals("564613I",cBD.getDni());
		assertEquals(new Date(1995-1900,2,25),cBD.getFecha_nacimiento());
		
		BBDD.eliminarCiudadano("564613I");
		cBD = BBDD.obtenerCiudadano("564613I");
		assertNull(cBD);
		
		
	}
	
	@Test
	public void testCargarCSV(){
		LoadUsers l = new LoadUsers();
		// leemos el fichero
		l.pruebaUsuarios("./src/test/java/es/uniovi/asw/test.xlsx");
		
		// cargamos la lista de  ciudadanos
		List<Ciudadano> ciudadanos =l.pruebaUsuarios("./src/test/java/es/uniovi/asw/test.xlsx");
		
		// probamos con el primer ciudadano
		Ciudadano c = ciudadanos.get(0);
		assertEquals("Juan", c.getNombre());
		assertEquals("Torres Pardo", c.getApellidos());
		assertEquals("juan@example.com", c.getEmail());
		//assertEquals("1985-10-10", String.valueOf(c.getFecha_nacimiento()));
		assertEquals("C/ Federico García Lorca 2", c.getDireccion());
		assertEquals("Español", c.getNacionalidad());
		assertEquals("90500084Y", c.getDni());
		
		// probamos con el segundo ciudadano
		c = ciudadanos.get(1);
		assertEquals("Luis", c.getNombre());
		assertEquals("López Fernando", c.getApellidos());
		assertEquals("luis@example.com", c.getEmail());
		//assertEquals("1970-03-02", String.valueOf(c.getFecha_nacimiento()));
		assertEquals("C/ Real Oviedo 2", c.getDireccion());
		assertEquals("Español", c.getNacionalidad());
		assertEquals("19160962F", c.getDni());
		
		// probamos con el tercer ciudadano
		c = ciudadanos.get(2);
		assertEquals("Ana", c.getNombre());
		assertEquals("Torres Pardo", c.getApellidos());
		assertEquals("ana@example.com", c.getEmail());
		//assertEquals("1960-01-01", String.valueOf(c.getFecha_nacimiento()));
		assertEquals("Av. De la Constitución 8", c.getDireccion());
		assertEquals("Español", c.getNacionalidad());
		assertEquals("09940449X", c.getDni());
	}

}
