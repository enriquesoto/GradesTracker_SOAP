package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.UsuarioController;

public class UsuarioControllerTest {

	public static String SUCCESS = "success";
	
	private String username;
	private String password;
	
	@Before 
	public void setUp(){
		username="20080561";
		password="20080561";
	}
	
	@Test
	public void testValidateLogin() {
		//fail("Not yet implemented");
		UsuarioController myUserController = new UsuarioController();
		myUserController.setDni(username);
		myUserController.setPassword(password);
		assertEquals("usuario 20080561", SUCCESS, myUserController.validateLogin());
	}

}
