package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.Connect;
import model.Matricula;


public class NotasConsulta {
	public String misNotasHistorico( String username){
		Connect db = Connect.getDbCon();
		String title = "Mis Notas";
		
		ResultSet rss;
		ResultSet rs;
		try {
  			rss = db.query("SET @row=0");
  			rs = db.query(
  					" select (@row:=@row+1) AS row, c.curricula_id, c.id, "
  					+ "c.semestre div 2 as ano, c.semestre, c.nombre, cp.turno, "
  					+ "m.notaFinal, m.letras, c.creditos "
  					+ "from matriculas m, cursos_programados cp, cursos c, "
  					+ "usuarios u where m.cursos_programado_id = cp.id "
  					+ "and cp.curso_id = c.id and m.usuario_id= u.id "
  					+ "and u.username in ('"+username+"');");
  			
  			ArrayList<Matricula> al = new ArrayList<Matricula>();
  			while (rs.next())
  			{
//  				 //Retrieve by column name
  				Matricula mMatricula = new Matricula();
  				mMatricula.setRow(rs.getInt("row"));
  				mMatricula.setCurriculaId(rs.getInt("curricula_id"));
  				mMatricula.setId(rs.getInt("curricula_id"));
  				mMatricula.setAnho(rs.getInt("ano"));
  				mMatricula.setSemestre(rs.getInt("semestre"));
  				mMatricula.setNombre(rs.getString("nombre"));
  				mMatricula.setTurno(rs.getString("turno"));
  				mMatricula.setNotaFinal(rs.getInt("notaFinal"));
  				mMatricula.setLetras(rs.getString("letras"));
  				mMatricula.setCreditos(rs.getInt("creditos"));
  				al.add(mMatricula);
//  		
//  		
  			}

  			}catch (SQLException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
		return "ok"+username;
	}

}
