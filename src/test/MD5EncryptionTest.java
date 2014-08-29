package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tools.MD5Encryption;

public class MD5EncryptionTest {

	private String username;
	private String password;
	@Before 
	public void setUp(){
		username="20080561";
		password="20080561";
	}
	@Test
	public void testGetMD5() throws Exception {
		//fail("Not yet implemented");
		String nomd5 = "20080561";
		String expected = "09612c1568af6443dbc1781f14b6f5d9";
		assertEquals(expected, MD5Encryption.getMD5(nomd5));
	}

}
