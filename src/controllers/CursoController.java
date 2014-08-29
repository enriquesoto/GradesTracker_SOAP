package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import main.Connect;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.CursosDAO;

public class CursoController extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private  Map<String, Object> session;
	private String username;
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String mostrarCurso(){
		Connect db = Connect.getDbCon();
		int curricula = 4462002;
		
		ResultSet rs;
		try {
			rs = db.query("select id, componentes_formacion_id, nombre, creditos, horas_teoria, "
					+ "horas_semiPresecial,horas_teoricoPractico, horas_practica, semestre, "
					+ "prerequisitos from cursos where curricula_id="+curricula);
			
			ArrayList<CursosDAO> al = new ArrayList<CursosDAO>();
			
			while (rs.next())
			{
				 //Retrieve by column name
				
				CursosDAO mCursos = new CursosDAO();
				
				mCursos.setId(rs.getString("id"));
				mCursos.setCompForId(rs.getString("componentes_formacion_id"));
				mCursos.setNombre(rs.getString("nombre"));
				mCursos.setCreditos(rs.getInt("creditos"));
				mCursos.setHorasTeoria(rs.getInt("horas_teoria"));
				mCursos.setHorasSemiPresecial(rs.getInt("horas_semiPresecial"));
				mCursos.setHorasTeoricoPractico(rs.getInt("horas_teoricoPractico"));
				mCursos.setHorasPractica(rs.getInt("horas_practica"));
				mCursos.setSemestre(rs.getInt("semestre"));
				mCursos.setPrerequisitos(rs.getString("prerequisitos"));
				
				al.add(mCursos);
			}

  			
			}catch (SQLException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return SUCCESS;
	}
}
