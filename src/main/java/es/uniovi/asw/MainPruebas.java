package es.uniovi.asw;

//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import dao.Ciudadano;

public class MainPruebas {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		Ciudadano a = new Ciudadano("Nacho", "Martin Franco", "miemail@gmail.com", "12312312A", 
//				"Calle Uria Oviedo", "Senegal", new Date(6, 2, 1995));
//		Ciudadano b = new Ciudadano("Pepe", "pepin pepon", "pepesemail@gmail.com", "12312312B", 
//				"Calle Uria Gijon", "Mozambique", new Date(6, 3, 1992));
//		
//		List<Ciudadano> cius = new ArrayList<Ciudadano>();
//		cius.add(a);
//		cius.add(b);
//		//BBDD bbdd = new BBDD();
//		BBDD.insertarCiudadano(cius);
		
		AddUsuario cargarUsuarios= new AddUsuario();
		cargarUsuarios.execute();
		
	}

}
