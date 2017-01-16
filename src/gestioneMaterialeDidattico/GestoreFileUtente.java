package gestioneMaterialeDidattico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestioneUtente.Utente;
import storageLayer.DatabaseGM;

/**
 * Servlet implementation class GestoreFileUtente
 */
@WebServlet("/GestoreFileUtente")
public class GestoreFileUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestoreFileUtente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Con il doGet di questa classe è possibile visualizzare e gestire i file
	 * dell'utente
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String utenteMail = ((Utente) session.getAttribute("user")).getEmail();

		System.out.println("emil " + utenteMail);

		if ((utenteMail == null) || utenteMail.equals("")) {

			request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
		}

		else {

			try {
				ArrayList<Risorsa> risorse = new ArrayList<Risorsa>();
				risorse = DatabaseGM.doRetrieveAllByUtente(utenteMail);

				request.removeAttribute("listaRisorseUtente");
				request.setAttribute("listaRisorseUtente", risorse);
				request.getRequestDispatcher("MD-fileUtente.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("chatcccc");
				e.printStackTrace();
				request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
