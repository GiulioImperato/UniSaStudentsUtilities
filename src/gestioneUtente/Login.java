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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailLogin");
		String password = request.getParameter("passwordLogin");
		
		try {
			
			Utente u = DatabaseGU.getUtenteByID(email);
			
			if(u!=null)
			{
				if(u.getPassword().equals(password))
				{
					if(u.isStatus()==true)
					{
						HttpSession session = request.getSession();
						session.setAttribute("user", u);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					else
					{
						System.out.println("Account non attivato");
					}
				}
				else
				{
					System.out.println("Email o password errati");
				}
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
