package es.uniovi.asw;

import static org.junit.Assert.*;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.Ciudadano;

public class BBDDTest {
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

}
