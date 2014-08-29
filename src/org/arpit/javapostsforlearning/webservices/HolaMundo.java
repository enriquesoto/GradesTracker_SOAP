package org.arpit.javapostsforlearning.webservices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.Connect;
import model.Matricula;
import model.Usuario;

public class HolaMundo {

    public String sayHelloWorld(String name)
    {  
    	Connect db = Connect.getDbCon();
		String title = "Mis Notas";
		String resultado = "";
		String cursoCod = "0201102";
		ResultSet rss;
		ResultSet rs;
		
		try {
  			rss = db.query("SET @row=0");
  			rs = db.query(
  					"Select c.curricula_id, c.id, c.semestre div 2 as ano, c.semestre, c.nombre, "
  					+"cp.turno,	m.notaFinal, m.letras, c.creditos "
  					+"from matriculas m, cursos_programados cp, cursos c,"
  					+"usuarios u "
  					+"where m.cursos_programado_id = cp.id " 
  					+"and cp.curso_id = c.id and m.usuario_id= u.id "
  					+"and c.semestre= (select max(semestre) from cursos) "
  					+ "and u.username in ("+name+") ;");
  			
  			ArrayList<Matricula> al = new ArrayList<Matricula>();
  			while (rs.next())
  			{
 				Matricula mMatricula = new Matricula();
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
  				resultado +=" ; "+mMatricula.getNombre()+ ": "+mMatricula.getLetras();		
//  				resultado = mMatricula.getNombre();
  			}
//  			for( int i = 0 ; i < al.size() ; i++ ){
//  			  System.out.println( al.get( i ) );
//  			}

  			}catch (SQLException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
		return "Su nota es: "+ resultado;
		//return al;
    }  

}








/*############################################################################*/


//package org.arpit.javapostsforlearning.webservices;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import main.Connect;
//import model.Matricula;
//import model.Usuario;
//
//public class HolaMundo {
//
//    public String sayHelloWorld(String name, String codCurso)
//	//public ArrayList<Matricula> sayHelloWorld(String name)
//    {  
//    	Connect db = Connect.getDbCon();
//		String title = "Mis Notas";
//		String resultado = "";
//		String cursoCod = "0201102";
//		ResultSet rss;
//		ResultSet rs;
//		
//		try {
//  			rss = db.query("SET @row=0");
//  			rs = db.query(
//  					" select c.curricula_id, c.id, "
//  					+ "c.semestre div 2 as ano, c.semestre, c.nombre, cp.turno, "
//  					+ "m.notaFinal, m.letras, c.creditos "
//  					+ "from matriculas m, cursos_programados cp, cursos c, "
//  					+ "usuarios u where m.cursos_programado_id = cp.id "
//  					+ "and cp.curso_id = c.id and m.usuario_id= u.id "
//  					+ "and c.id ="+codCurso+" and u.username in ('"+name+"') ;");
////  			"select nombres as nombres, apellidos as apel from usuarios where username in ('"+name+"');");
//  			
//  			ArrayList<Matricula> al = new ArrayList<Matricula>();
////  			ArrayList<Usuario> al = new ArrayList<Usuario>();
//  			while (rs.next())
//  			{
////  				 //Retrieve by column name
//  				Matricula mMatricula = new Matricula();
////  				Usuario mUsuario = new Usuario();
////  				mUsuario.setNombres(rs.getString("nombres"));
////  				mUsuario.setApellidos(rs.getString("apel"));
//  				
//  				//mMatricula.setRow(rs.getInt("row"));
//  				mMatricula.setCurriculaId(rs.getInt("curricula_id"));
//  				mMatricula.setId(rs.getInt("curricula_id"));
//  				mMatricula.setAnho(rs.getInt("ano"));
//  				mMatricula.setSemestre(rs.getInt("semestre"));
//  				mMatricula.setNombre(rs.getString("nombre"));
//  				mMatricula.setTurno(rs.getString("turno"));
//  				mMatricula.setNotaFinal(rs.getInt("notaFinal"));
//  				mMatricula.setLetras(rs.getString("letras"));
//  				mMatricula.setCreditos(rs.getInt("creditos"));
//  				al.add(mMatricula);
////  				resultado=mUsuario.getNombres();
////  				al.add(mUsuario);
//  				resultado=mMatricula.getLetras();
//  			
//  		
//  			}
//
//  			}catch (SQLException e1) {
//  			// TODO Auto-generated catch block
//  			e1.printStackTrace();
//  		}
//		
//        //return "Hello madeley "+ name;
//		return "Su nota es: "+ resultado;
//		//return al;
//    }  
//
//}
