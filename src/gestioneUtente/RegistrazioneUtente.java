package gestioneUtente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storageLayer.DatabaseGU;

/**
 * Servlet implementation class RegistrazioneUtente
 */
@WebServlet("/RegistrazioneUtente")
public class RegistrazioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrazioneUtente() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String n = request.getParameter("nome");
		String c = request.getParameter("cognome");
		String e = request.getParameter("email");
		String p = request.getParameter("password");
		boolean ss = false;
		boolean pa = false;
		
		
		
		boolean flag=false;
		try 
		{
			Utente u = DatabaseGU.getUtenteByID(e);
			
			if(u==null)
			{	
				flag=true;
			}
			else
			{
				flag=false;
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(flag)
		{
			try 
			{
				DatabaseGU.addUser(new Utente(n,c,e,p,ss,pa));
				//email link
				System.out.println(flag);
				
				response.sendRedirect("http://www.google.com");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
		{
			System.out.println(flag);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}