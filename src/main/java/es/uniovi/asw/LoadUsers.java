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

	public static List<Ciudadano> pruebaUsuarios(String ruta) {
		List<Ciudadano> participants = new ArrayList<Ciudadano>();
		try {
			FileInputStream file = new FileInputStream(new File(ruta));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				ArrayList<Object> aux = new ArrayList<Object>();
				for (int i = 0; i < 3; i++) {
					aux.add(row.getCell(i) != null ? row.getCell(i).toString() : null);
				}
				for (int i = 4; i < 7; i++) {
					aux.add(row.getCell(i) != null ? row.getCell(i).toString() : null);
				}

//				String fecha = row.getCell(3) != null ? row.getCell(3).toString() : null;

				Date nacimiento = null;
//				if (fecha != null && !fecha.equals("Fecha nacimiento")) {
//					SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//					nacimiento = (Date) sdf.parse(fecha);
//				}
				aux.add(nacimiento);

				Ciudadano ciudadano = new Ciudadano(aux.get(0).toString(), aux.get(1).toString(), aux.get(2).toString(),
						aux.get(3).toString(), aux.get(4).toString(), aux.get(5).toString(), (Date)aux.get(6));

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
}
