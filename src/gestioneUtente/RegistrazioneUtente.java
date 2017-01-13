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
	    
		String q = request.getParameter("q");
		
		//decrypt
		
		String chipher = EncryptionUtil.decode(q);
		
		
		String n = chipher.substring(5,chipher.indexOf("&"));
		
		String c = chipher.substring(chipher.indexOf("cognome=")+8,chipher.indexOf("email=")-1);
		
		String e = chipher.substring(chipher.indexOf("email=")+6,chipher.indexOf("password=")-1);
		
		String p = chipher.substring(chipher.indexOf("password=")+9);
		
		
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
				Utente u = new Utente(n,c,e,p,ss,pa);
				DatabaseGU.addUser(u);
				DatabaseGU.changeStatus(u.getEmail(), true);
				//email link
				
				request.getRequestDispatcher("regsuccess.jsp").forward(request, response);
				
				//response.sendRedirect("http://www.google.com");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
		{
			System.out.println("errore registrazione");
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
