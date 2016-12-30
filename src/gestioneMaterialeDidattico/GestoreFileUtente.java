package gestioneMaterialeDidattico;

import java.io.IOException;
import java.sql.SQLException;
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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String utente = ((Utente)session.getAttribute("utente")).getEmail();	


		if((utente==null) || utente.equals("")){
			request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
		}

		else{
			
			try {
				ArrayList<Risorsa> risorse = new ArrayList<Risorsa>();
				risorse=DatabaseGM.doRetrieveAllByUtente(utente);
				
				request.setAttribute("listaRisorseUtente", risorse);
				request.getRequestDispatcher("MD-fileUtente.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
			}
			
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
