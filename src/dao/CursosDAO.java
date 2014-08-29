package dao;

public class CursosDAO {

	String id ; 
	String compForId;
	String nombre;
	int creditos ;
	int horasTeoria;
	int horasSemiPresecial;
	int horasTeoricoPractico;
	int horasPractica ;
	int semestre ;
	String prerequisitos;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompForId() {
		return compForId;
	}
	public void setCompForId(String compForId) {
		this.compForId = compForId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getHorasTeoria() {
		return horasTeoria;
	}
	public void setHorasTeoria(int horasTeoria) {
		this.horasTeoria = horasTeoria;
	}
	public int getHorasSemiPresecial() {
		return horasSemiPresecial;
	}
	public void setHorasSemiPresecial(int horasSemiPresecial) {
		this.horasSemiPresecial = horasSemiPresecial;
	}
	public int getHorasTeoricoPractico() {
		return horasTeoricoPractico;
	}
	public void setHorasTeoricoPractico(int horasTeoricoPractico) {
		this.horasTeoricoPractico = horasTeoricoPractico;
	}
	public int getHorasPractica() {
		return horasPractica;
	}
	public void setHorasPractica(int horasPractica) {
		this.horasPractica = horasPractica;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public String getPrerequisitos() {
		return prerequisitos;
	}
	public void setPrerequisitos(String prerequisitos) {
		this.prerequisitos = prerequisitos;
	}
	
	

}
