package gestioneVendite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestioneUtente.Utente;
import storageLayer.DatabaseGV;

/**
 * Servlet implementation class GestoreLibriServlet
 */
@WebServlet("/GestoreLibriServlet")
public class GestoreLibriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ArrayList<Annuncio>listAnnunci;
	static ArrayList<DettagliAnnuncio>listDettagli;
	static ArrayList<Annuncio>listAnnunciByTitle;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestoreLibriServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**<b>Permette di visualizzare gli annunci di un utente</b>
	 * @author Pasquale Settembre
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String azione = request.getParameter("azione");
		System.out.println("az "+azione);
		if(azione.equalsIgnoreCase("visualizzaMieiAnnunci")){
			HttpSession session = request.getSession();
			Utente u = (Utente) session.getAttribute("user");
			String proprietario = u.getEmail();
			try {
				listAnnunci = DatabaseGV.getListaAnnunciUtente(proprietario);
				listDettagli = DatabaseGV.getListaDettagli();
				request.setAttribute("listaAnnunci", listAnnunci);
				request.setAttribute("listDettagli", listDettagli);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("GV-MieiAnnunci.jsp").forward(request, response);
		}
		
		
		
	}

	/**<b>Permette l'inserimento di un annuncio chiamando DatabaseGV</b>
	 *@author Pasquale Settembre
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String azione = request.getParameter("azione");
		
		if(azione.equalsIgnoreCase("inserisciAnnuncio")){
			String path = request.getParameter("path");
			System.out.println("PATH "+path);
			String titoloLibro = request.getParameter("titolo-libro");	 
			String autore = request.getParameter("autore-libro");
			String editore = request.getParameter("editore-libro");
			String year = request.getParameter("anno-libro");
			String proprietario = request.getParameter("email");
			System.out.println("prop "+proprietario);
			int anno = Integer.parseInt(year);
			CondizioneLibro condizione = CondizioneLibro.valueOf(request.getParameter("condizioni"));
			String price = request.getParameter("prezzo-libro");
			double prezzo = Double.parseDouble(price);
			String corso = request.getParameter("corso-libro");
			String descrizione = request.getParameter("descrizione");

			DettagliAnnuncio dt = new DettagliAnnuncio(editore, anno, descrizione, new Date(), path);
			Annuncio annuncio = new Annuncio(titoloLibro, autore, corso, proprietario, condizione, prezzo, dt);
			try {
				DatabaseGV.addAnnuncio(annuncio, dt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/*
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
		if(azione.equalsIgnoreCase("ricercaAnnunci")){
			String titolo = request.getParameter("titolo");
			try {
				listAnnunciByTitle = DatabaseGV.getListaAnnunciRicercaTitolo(titolo);
				System.out.println(listAnnunciByTitle.toString());
				request.setAttribute("listaAnnunciByTitle", listAnnunciByTitle);
				System.out.println("dsadsad");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GV-RicercaLibri.jsp");
			dispatcher.forward(request, response);
		}
	}

}
