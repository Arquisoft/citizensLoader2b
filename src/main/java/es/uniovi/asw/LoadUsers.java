package es.uniovi.asw;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.Ciudadano;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	@SuppressWarnings("deprecation")
	public List<Ciudadano> pruebaUsuarios(String ruta) {
		List<Ciudadano> participants = new ArrayList<Ciudadano>();
		try {
			FileInputStream file = new FileInputStream(new File(ruta));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				ArrayList<Object> aux = new ArrayList<Object>();
				for (int i = 0; i < 7; i++) {
					aux.add(row.getCell(i) != null ? row.getCell(i).toString() : null);
				}
//				for (int i = 4; i < 7; i++) {
//					aux.add(row.getCell(i) != null ? row.getCell(i).toString() : null);
//				}

//				String fecha = row.getCell(3) != null ? row.getCell(3).toString() : null;

				
				String fecha = String.valueOf(aux.get(3));
				String mesS = fecha.split("-")[1];
				
				int mes = sacarMes(mesS);
				int dia = Integer.parseInt(fecha.split("-")[0]);
				
				
				int year = Integer.parseInt(fecha.split("-")[2]);
				Date nacimiento = new Date(year-1900, mes-1, dia) ;
				
//				if (fecha != null && !fecha.equals("Fecha nacimiento")) {
//					SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//					nacimiento = (Date) sdf.parse(fecha);
//				}

				Ciudadano ciudadano = new Ciudadano(aux.get(0).toString(), aux.get(1).toString(), aux.get(2).toString(),
						aux.get(4).toString(), aux.get(5).toString(), aux.get(6).toString(), nacimiento);

				participants.add(ciudadano);
			}

			file.close();
			workbook.close();
		} catch (Exception e) {
			System.err.println("Error al leer del excel");
			e.printStackTrace();
		}
		return participants;
	}

	private int sacarMes(String mesS) {
		int mes = 0;
		
		if(mesS.equals("ene")){
			mes=1;
		}
		if(mesS.equals("feb")){
			mes=2;
		}
		if(mesS.equals("mar")){
			mes=3;
		}
		if(mesS.equals("abr")){
			mes=4;
		}
		if(mesS.equals("may")){
			mes=5;
		}
		if(mesS.equals("jun")){
			mes=6;
		}
		if(mesS.equals("jul")){
			mes=7;
		}
		if(mesS.equals("ago")){
			mes=8;
		}
		if(mesS.equals("sep")){
			mes=9;
		}
		if(mesS.equals("oct")){
			mes=10;
		}
		if(mesS.equals("nov")){
			mes=11;
		}
		if(mesS.equals("dic")){
			mes=12;
		}
//		
//		switch(mesS){
//			case "ene":
//				mes =1;
//				break;
//				
//			case "feb":
//				mes =2;
//				break;
//				
//			case "mar":
//				mes =3;
//				break;
//				
//			case "abr":
//				mes =4;
//				break;
//				
//			case "may":
//				mes =5;
//				break;
//				
//			case "jun":
//				mes =6;
//				break;
//				
//			case "jul":
//				mes =7;
//				break;
//				
//			case "ago":
//				mes =8;
//				break;
//				
//			case "sep":
//				mes =9;
//				break;
//				
//			case "oct":
//				mes= 10;
//				break;
//				
//			case "nov":
//				mes =11;
//				break;
//				
//			case "dic":
//				mes =12;
//				break;
//			
//		}
		return mes;
	}
}
