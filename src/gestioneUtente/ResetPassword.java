package gestioneUtente;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storageLayer.DatabaseGU;

/**
 * Servlet implementation class ResetPassword
 * Gestisce il reset della password per l'account utente.
 * 
 * @author AntonioEsposito GiuseppeAdinolfi
 * 
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String q=request.getParameter("q");
		
		//decrypt
		
		String chipher = EncryptionUtil.decode(q);
		String password = chipher.substring(9, chipher.indexOf("&"));
		String email = chipher.substring(chipher.indexOf("email=")+6);
		
		
		try
		{
			DatabaseGU.cambiaPassword(email, password);
			request.getRequestDispatcher("resetsuccess.jsp").forward(request, response);
			
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
