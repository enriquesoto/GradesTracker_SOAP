package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*; 
import javax.servlet.http.*;

import dao.CurriculaDAO;
import main.Connect;


/**
 * Servlet implementation class hola

 */
public class CurriculaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurriculaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("holaaaaa");
		Connect db = Connect.getDbCon();
	    String title = "CURRICULAS";
		ResultSet rs;
		try {
			ArrayList<CurriculaDAO> al = new ArrayList<CurriculaDAO>();
			
			rs = db.query("Select * from curriculas");
			while (rs.next())
			{
				 //Retrieve by column name
				
				CurriculaDAO mCurricula = new CurriculaDAO();
				mCurricula.setId(rs.getInt("id"));
				mCurricula.setAnoIni(rs.getInt("anho_inicio"));
				mCurricula.setAnoFin(rs.getInt("anho_fin"));
				mCurricula.setDescripcion(rs.getString("descripcion"));
				mCurricula.setSpreadsheetkey(rs.getString("spreadsheetkey"));
							
//		
//
//	            //Display values
//	            out.println("<TR>");
//	            out.println("<TD WIDTH=100> " + id + "</TD>");
//	            out.println("<TD WIDTH=600> " + anoIni + "</TD>");
//	            out.println("<TD WIDTH=400> " + anoFin + "</TD>");
//	            out.println("<TD WIDTH=400> " + descripcion + "</TD>");
//	            out.println("<TD WIDTH=100> " + spreadsheetkey + "</TD>");
//	            out.println("</TR>");
				al.add(mCurricula);
		
			}
			request.setAttribute("curriculaList", al);
  			getServletConfig().getServletContext().getRequestDispatcher("/vercurriculas.jsp").forward(request,response);
//			out.println("</TABLE>");
//			out.println("</body></html>");
			}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			

	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
