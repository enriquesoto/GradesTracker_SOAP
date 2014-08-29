package dao;

public class CurriculaDAO {

	 int id ; 
     int anoIni;
     int anoFin;
     String descripcion;
     String spreadsheetkey;
     
     
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSpreadsheetkey() {
		return spreadsheetkey;
	}
	public void setSpreadsheetkey(String spreadsheetkey) {
		this.spreadsheetkey = spreadsheetkey;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnoIni() {
		return anoIni;
	}
	public void setAnoIni(int anoIni) {
		this.anoIni = anoIni;
	}
	public int getAnoFin() {
		return anoFin;
	}
	public void setAnoFin(int anoFin) {
		this.anoFin = anoFin;
	}
     
     
}
