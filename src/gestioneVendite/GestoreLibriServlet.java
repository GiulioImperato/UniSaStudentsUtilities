package gestioneVendite;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	static ArrayList<Annuncio>listMyAnnunci;
	static ArrayList<DettagliAnnuncio>listDettagli;
	static ArrayList<Annuncio>listAnnunciByTitle;
	static ArrayList<Annuncio>listAnnunciByTitleAuthor;
	static ArrayList<Annuncio>listAnnunciByCorso;

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
				listMyAnnunci = DatabaseGV.getListaAnnunciUtente(proprietario);
				listDettagli = DatabaseGV.getListaDettagli();
				request.setAttribute("listaAnnunci", listMyAnnunci);
				request.setAttribute("listDettagli", listDettagli);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("GV-MieiAnnunci.jsp").forward(request, response);
		}



	}

	/**<b>In base al parametro azione, permette l'inserimento o ricerca di un annuncio  chiamando DatabaseGV</b>
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
			BigDecimal prezzo = new BigDecimal(price);
			String corso = request.getParameter("corso-libro");
			String descrizione = request.getParameter("descrizione");

			DettagliAnnuncio dt = new DettagliAnnuncio(editore, anno, descrizione, new Date(), path);
			Annuncio annuncio = new Annuncio(titoloLibro, autore, corso, proprietario, condizione, prezzo, dt);
			try {
				DatabaseGV.addAnnuncio(annuncio, dt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(azione.equalsIgnoreCase("inviamessaggio")){
			PrintWriter out = response.getWriter();
			String pass = request.getParameter("passwordSender");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String host = "unisa.smtpauth.cineca.it";
			String port = "465";
			String user = request.getParameter("user");
			String destinatario = request.getParameter("dest");
			
			try {
				EmailUtility.sendEmail(host, port, user, pass, destinatario, subject,content);
				out.println("<script>");
	            out.println("alert('E-MAIL INVIATA CORRETTAMENTE !')");
	            out.println("window.history.back()");
	            out.println("</script>");
			} catch (Exception ex) {
				ex.printStackTrace();
				out.println("<script>");
	            out.println("alert('Errore: password errata !')");
	            out.println("window.history.back()");
	            out.println("</script>");
			} finally {
				System.out.println("finito");
			}
		}
		
		
		if(azione.equalsIgnoreCase("ricercaAnnunci")){
			String titolo = request.getParameter("titolo");
			String autore = request.getParameter("autore");
			String corso = request.getParameter("corso");
			if(!titolo.equalsIgnoreCase("") || !autore.equalsIgnoreCase("") || corso!=null){
				if(corso!=null){
					try{
						listAnnunciByCorso = DatabaseGV.getListaAnnunciRicercaByCorso(corso);
						request.setAttribute("listaAnnunci", listAnnunciByCorso);
						request.setAttribute("vis", "visible");
					}catch (SQLException e) {
						e.printStackTrace();
					}
					request.getRequestDispatcher("GV-RicercaLibri.jsp").forward(request, response);
					return;
				}
				
				if(!titolo.equalsIgnoreCase("") && !autore.equalsIgnoreCase("")){   //se vengono immessi titolo e autore nella ricerca
					try {
						listAnnunciByTitleAuthor = DatabaseGV.getListaAnnunciRicercaTitleAuthor(titolo,autore);
						if(listAnnunciByTitleAuthor.size()==0){
							request.setAttribute("noresult", "noresult");
							request.getRequestDispatcher("GV-RicercaLibri.jsp").forward(request, response);
							return;
						}
						else{
							request.setAttribute("listaAnnunci", listAnnunciByTitleAuthor);
							request.setAttribute("vis", "visible");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					request.getRequestDispatcher("GV-RicercaLibri.jsp").forward(request, response);
				}
				else{      //se viene immesso il titolo o l'autore nella ricerca
					try {
						listAnnunciByTitle = DatabaseGV.getListaAnnunciRicerca(titolo,autore);
						if(listAnnunciByTitle.size()==0){
							request.setAttribute("noresult", "noresult");
							request.getRequestDispatcher("GV-RicercaLibri.jsp").forward(request, response);
							return;
						}
						else{
							request.setAttribute("listaAnnunci", listAnnunciByTitle);
							request.setAttribute("vis", "visible");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					request.getRequestDispatcher("GV-RicercaLibri.jsp").forward(request, response);
				}
			}
			else{
				response.sendRedirect("/usu/GV-RicercaLibri.jsp");
			}
		}
	}
}
