package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controllers.NotasController;

public class NotasControllerTest {
	
	private ArrayList<Double> notasExpected = new ArrayList<Double>();
	
	@Before 
	public void setUp(){
		notasExpected.add(20.0);notasExpected.add(20.0);
		notasExpected.add(20.0);notasExpected.add(20.0);
	}
	
	@Test(timeout=3000)
	public void tesMisNotasParciales() {
		//fail("Not yet implemented");
		
		NotasController aNotasController = new NotasController();
		
		aNotasController.setUsername("20080561");
		aNotasController.misNotasParciales();
		assertEquals(notasExpected, aNotasController.notas);
		
		
	}

}
