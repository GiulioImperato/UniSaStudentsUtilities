package gestioneMaterialeDidattico;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import gestioneUtente.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import storageLayer.DatabaseGM;

/**
 * Servlet implementation class GestoreEliminaRisorsa
 */
@WebServlet("/GestoreEliminaRisorsa")
public class GestoreEliminaRisorsa extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public GestoreEliminaRisorsa() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		String utente = ((Utente)session.getAttribute("user")).getEmail();	


		if((utente==null) || utente.equals("")){
			request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
		}

		else{


			String azione = (String)request.getParameter("action").trim();					
			String elimina = (String)request.getParameter("idRis").trim();
			ArrayList<Risorsa> risorse = null;


			if(azione.equals("all")){

				try {
					System.out.println("elimina tutto");
					boolean b =DatabaseGM.deleteRisorseOfUtente(utente);
					//risorse =DatabaseGM.doRetrieveAllByUtente(utente);
					risorse=null;
					///System.out.println("result "+b);
					
				} catch (Exception  e) {
					request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
				}
				request.removeAttribute("listaRisorseUtente");
				request.setAttribute("listaRisorseUtente", risorse);
				request.getRequestDispatcher("MD-fileUtente.jsp").forward(request, response);

			}

			else if(azione.equals("one")){


				try{
					int id = Integer.parseInt(elimina);
					DatabaseGM.deleteRisorsa(id);
					risorse =DatabaseGM.doRetrieveAllByUtente(utente);


				}catch (Exception e) {
					request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
				}
				
				request.removeAttribute("listaRisorseUtente");
				request.setAttribute("listaRisorseUtente", risorse);
				request.getRequestDispatcher("MD-fileUtente.jsp").forward(request, response);

			}

			else{

				request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
			}


		}



	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
