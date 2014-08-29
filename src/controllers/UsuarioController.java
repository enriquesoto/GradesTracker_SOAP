package controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import main.Connect;

import org.apache.struts2.interceptor.SessionAware;
import org.omg.CORBA.PUBLIC_MEMBER;

import tools.MD5Encryption;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UsuarioDao;

public class UsuarioController extends ActionSupport implements SessionAware  {
	
	private static final long serialVersionUID = 1L;
	private String dni;
	private String password;
	private  Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String validateLogin() {

		//System.out.println("salida:" + dni +"-" +password);
		
		if(UsuarioDao.validate(dni, password)){
			
			session.put("loggined",true);
			session.put("username",20080561);
			
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String agregarUsuario(){
		// TODO Auto-generated method stub
				//PrintWriter out = response.getWriter();
				Connect db = Connect.getDbCon();
				
				
			    String username = "20080561";
			    String password=null;
			    try {
					password = MD5Encryption.getMD5("20080561");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    String apellidos = "apellidos";
			    String nombres = "nombres";
			    String fecha_nacimiento = "1990-07-20";
			    String correo = "correo";
			    
			    int rs;
			    try {
			    	rs = db.insert("Insert into usuarios (username, password, apellidos, nombres,"
			    			+ "fecha_nacimiento, correo) values ('"+username+"','"+password+"','"+apellidos+"','"
			    			+nombres+"','"+fecha_nacimiento+"','"+correo+"')");
			    	
			    	rs = db.insert("Insert into roles_usuarios ( usuario_id, rol_id) values "+ "('"+rs+"','1')");
			    	
			    	
			    	//request.getRequestDispatcher("MensajeRegistro.jsp").forward(request, response);
			    	    
			    	   
			    
			    	
					}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
				}
			    return SUCCESS;
	}
	
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	
	
	
}
