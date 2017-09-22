package gestioneUtente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storageLayer.DatabaseGU;

/**
 * Servlet implementation class ConfermaReset	 
 * Questa servlet crea una password alfanumerica nuova per il reset e la invia per email all'utente.
 * Nell'email sarà presente il link di conferma reset.
 * 
 * @author AntonioEsposito
 */
@WebServlet("/ConfermaReset")
public class ConfermaReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfermaReset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String email = request.getParameter("resetemail");
		String host = "smtp.gmail.com";
		String port = "587";
		String emailusu = "studentutilitiesnoreply@gmail.com";
		String passwordusu = "studentutilitiesnoreply123";
		
		try{
		
			Utente u = DatabaseGU.getUtenteByID(email);
			
			System.out.println(u.getEmail());
			
			String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			StringBuilder builder = new StringBuilder();
			int count=8;
			
			String newPassword=null;
			
			while (count-- != 0) {

			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			
			newPassword = builder.toString();
			}
			
		
		if(u!=null)
		{
			System.out.println(u.getEmail());
			EmailUtilityReset.sendEmail(host, port, emailusu, passwordusu, email,newPassword);
			request.getRequestDispatcher("alertreset.jsp").forward(request, response);
		}
		}catch (Exception e) {
			// TODO: handle exception
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
