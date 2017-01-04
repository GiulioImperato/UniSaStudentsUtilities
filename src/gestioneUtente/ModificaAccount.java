package gestioneUtente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storageLayer.DatabaseGU;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ModificaAccount")
public class ModificaAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Utente user =(Utente) session.getAttribute("user");
		
		String action = request.getParameter("action");

		String pass = request.getParameter("password");
		String cpass = request.getParameter("confirmpassword");
		
		boolean flag=false;
		
		if(pass.equals(cpass))
		{
			flag=true;
		}
		
		if ("Update".equals(action)) {
			
			if(flag)
			{
				DatabaseGU.cambiaPassword(user.getEmail(), request.getParameter("confirmpassword"));
				request.setAttribute("flag",flag);
				request.getRequestDispatcher("modifica-account.jsp").forward(request, response);
			}
			//System.out.println("Update account");
			
		} else if ("Elimina".equals(action)) {
		    
			try {
				
				//System.out.println("Elimina account");
				DatabaseGU.deleteUser(user.getEmail());
				session.removeAttribute("user");
				session.invalidate();
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
